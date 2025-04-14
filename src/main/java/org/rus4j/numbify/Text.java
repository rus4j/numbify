package org.rus4j.numbify;

import java.util.StringJoiner;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class Text {
    public String toIntText(StringNumber number, Language lang) {
        String numText = toText(new NumberGroup(number).integerGroup(), lang, false);
        return number.isNegative() ? "- " + numText : numText;
    }

    public String toDecimalText(StringNumber number, Language lang) {
        return toText(new NumberGroup(number).decimalGroup(), lang, true);
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