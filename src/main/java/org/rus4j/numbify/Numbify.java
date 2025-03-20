package org.rus4j.numbify;

import java.util.StringJoiner;

public class Numbify {

    private final Language lang;
    private final boolean showIntegerCurrency;
    private final boolean showDecimalCurrency;

    public Numbify(Language lang, boolean showIntegerCurrency, boolean showDecimalCurrency) {
        this.lang = lang;
        this.showIntegerCurrency = showIntegerCurrency;
        this.showDecimalCurrency = showDecimalCurrency;
    }

    public String toText(Number number) {
        NumberGroup numberGroup = new NumberGroup(number);
        int[][] ints = numberGroup.integerGroup();
        int[][] decimals = numberGroup.decimalGroup(lang.hasSpecificCurrency());
        int[] lastIntDigits = ints[ints.length - 1];
        StringJoiner result = new StringJoiner(" ");

        result.add(toText(ints, false));
        if (showIntegerCurrency && !lang.intCurrency(lastIntDigits).isEmpty()) {
            result.add(lang.intCurrency(lastIntDigits));
        }
        if (!lang.numberPartsDelimiter().isEmpty()) {
            result.add(lang.numberPartsDelimiter());
        }
        if (decimals.length > 0) {
            result.add(toText(decimals, true));
            if (showDecimalCurrency) {
                result.add(lang.decimalCurrency(decimals[decimals.length - 1], numberGroup.decimalLength()));
            }
        }
        return result.toString();
    }

    private String toText(int[][] groups, boolean isDecimal) {
        StringJoiner result = new StringJoiner(" ");
        for (int i = 0; i < groups.length; i++) {
            int scale = groups.length - 1 - i;
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) continue;
            result.add(groupToText(groups[i], scale, isDecimal));
            if (scale == 1) {
                result.add(lang.thousands(groups[i]));
            } else if (scale > 1) {
                result.add(lang.largeNumbers(scale - 2) + lang.endings(groups[i]));
            }
        }
        return result.toString();
    }

    private String groupToText(int[] digits, int groupNum, boolean isDecimal) {
        String hundredText = lang.hundreds(digits[0]);
        String tenText;
        String unitText = "";
        if (digits[1] == 1) {
            tenText = lang.tenToNineteen(digits[2]);
        } else {
            tenText = lang.tens(digits[1]);
            unitText = lang.unitNumber(groupNum, digits, isDecimal);
        }

        if (!hundredText.isEmpty() && tenText.isEmpty() && unitText.isEmpty()) {
            return hundredText;
        }
        if (!tenText.isEmpty() && hundredText.isEmpty() && unitText.isEmpty()) {
            return tenText;
        }
        if (!unitText.isEmpty() && hundredText.isEmpty() && tenText.isEmpty()) {
            return unitText;
        }
        if (!unitText.isEmpty() && !tenText.isEmpty() && hundredText.isEmpty()) {
            return tenText + " " + unitText;
        }
        if (!unitText.isEmpty() && tenText.isEmpty()) {
            return hundredText + " " + unitText;
        }
        if (!hundredText.isEmpty() && unitText.isEmpty()) {
            return hundredText + " " + tenText;
        }
        if (!unitText.isEmpty()) {
            return hundredText + " " + tenText + " " + unitText;
        }
        return null;
    }
}