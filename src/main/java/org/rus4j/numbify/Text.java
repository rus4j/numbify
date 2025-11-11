package org.rus4j.numbify;

import java.util.StringJoiner;
import org.rus4j.numbify.lang.Language;

public class Text implements TextEngine {
    /**
     * The delimiter used to separate groups of words when converting a number into text.
     * <p>
     * Numbers are divided into groups of three digits (hundreds, thousands, millions, etc.).
     * The delimiter defines how these groups are joined together in the resulting text.
     * <p>
     * For example, if {@code delimiter = "-"}, the number {@code 1234} will be converted to
     * {@code "one-thousand-two hundred thirty four"}.
     * <p>
     * In some languages, such as German, numbers are written as a single continuous word.
     * In this case, {@code delimiter} should be an empty string ({@code ""}),
     * and {@code 1234} would be rendered as {@code "eintausendzweihundertvierunddreißig"}.
     */
    private final String delimiter;

    public Text(String delimiter) {
        this.delimiter = delimiter;
    }

    public Text() {
        this(" ");
    }

    @Override
    public String toText(String number, Language lang, boolean isDecimal) {
        int[][] group = number.isEmpty() ? new int[][]{} : new NumberGroup(number).group();
        return toText(group, lang, isDecimal);
    }

    private String toText(int[][] groups, Language lang, boolean isDecimal) {
        StringJoiner result = new StringJoiner(delimiter);
        for (int i = 0; i < groups.length; i++) {
            int scale = groups.length - 1 - i;
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) {
                continue;
            }
            result.add(groupToText(groups[i], scale, lang, isDecimal));
            if (scale == 1) {
                result.add(lang.thousands(groups[i]));
            } else if (scale > 1) {
                result.add(lang.largeNumbers(scale - 2, groups[i]));
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
        return lang.textOrder().text(hundredText, tenText, unitText, delimiter);
    }
}