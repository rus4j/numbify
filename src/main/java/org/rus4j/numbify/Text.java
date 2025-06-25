package org.rus4j.numbify;

import java.util.StringJoiner;
import org.rus4j.numbify.lang.Language;

public class Text implements TextEngine {

    @Override
    public String toText(String number, Language lang, boolean isDecimal) {
        int[][] group = number.isEmpty() ? new int[][]{} : new NumberGroup(number).group();
        return toText(group, lang, isDecimal);
    }

    private String toText(int[][] groups, Language lang, boolean isDecimal) {
        StringJoiner result = new StringJoiner(" ");
        for (int i = 0; i < groups.length; i++) {
            int scale = groups.length - 1 - i;
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) {
                continue;
            }
            result.add(groupToText(groups[i], scale, lang, isDecimal));
            if (scale == 1) {
                result.add(lang.thousands(groups[i]));
            } else if (scale > 1) {
                result.add(lang.largeNumbers(scale - 2) + lang.endings(groups[i]));
            }
        }
        return result.toString();
    }

    private String groupToText(int[] digits, int groupNum, Language lang, boolean isDecimal) {
        String hundredText = lang.hundreds(digits[0]);
        String tenText;
        String unitText = "";
        if (digits[1] == 1) {
            tenText = lang.tenToNineteen(digits[2]);
        } else {
            tenText = lang.tens(digits[1]);
            unitText = lang.unitNumber(groupNum, digits, isDecimal);
        }
        return lang.textOrder().text(hundredText, tenText, unitText);
    }
}