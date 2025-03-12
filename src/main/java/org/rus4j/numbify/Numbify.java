package org.rus4j.numbify;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbify {

    private final Language lang;
    private final boolean showIntegerCurrency;
    private final boolean showDecimalCurrency;

    public Numbify(Language lang, boolean showIntegerCurrency, boolean showDecimalCurrency) {
        this.lang = lang;
        this.showIntegerCurrency = showIntegerCurrency;
        this.showDecimalCurrency = showDecimalCurrency;
    }

    public String toText(Double number) {
        NumberGroup numberGroup = new NumberGroup(number);
        int[][] groups = numberGroup.decimalGroup(lang.hasSpecificCurrency());
        String decimalText = toText(groups, true);

        StringJoiner result = new StringJoiner(" ")
                .add(toText(number.longValue()));
        if (!lang.numberPartsDelimiter().isEmpty()) result.add(lang.numberPartsDelimiter());
        result.add(decimalText);
        if (showDecimalCurrency) result.add(lang.decimalCurrency(groups[0], numberGroup.decimalLength()));
        return result.toString();
    }

    public String toText(Integer number) {
        return toText(number.longValue());
    }

    public String toText(Long number) {
        int[][] groups = new NumberGroup(number).integerGroup();
        String text = toText(groups, false);
        StringJoiner result = new StringJoiner(" ")
                .add(text);
        if (showIntegerCurrency) result.add(lang.intCurrency(groups[0]));
        return result.toString().trim();
    }

    private String toText(int[][] groups, boolean isDecimal) {
        StringJoiner result = new StringJoiner(" ");
        for (int i = groups.length - 1; i >= 0; i--) {
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) continue;
            result.add(groupToText(groups[i], i, isDecimal));
            if (i == 1) {
                result.add(lang.thousands(groups[i]));
            } else if (i > 1) {
                result.add(lang.largeNumbers(i - 2) + lang.endings(groups[i]));
            }
        }
        return result.toString();
    }

    private String groupToText(int[] digits, int groupNum, boolean isDecimal) {
        String hundredText = lang.hundreds(digits[2]);
        String tenText;
        String unitText = "";
        if (digits[1] == 1) {
            tenText = lang.tenToNineteen(digits[0]);
        } else {
            tenText = lang.tens(digits[1]);
            unitText = lang.unitNumber(groupNum, digits, isDecimal);
        }
        return Stream.of(hundredText, tenText, unitText)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }
}