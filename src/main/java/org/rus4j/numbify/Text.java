package org.rus4j.numbify;

import java.util.StringJoiner;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.DefaultNumber;
import org.rus4j.numbify.number.RoundedNumber;
import org.rus4j.numbify.number.StringNumber;

public class Text {
    private final Language lang;
    private final DigitGroupOrder digitGroupOrder;

    public Text(Language lang, DigitGroupOrder digitGroupOrder) {
        this.lang = lang;
        this.digitGroupOrder = digitGroupOrder;
    }

    public String intText(Number number) {
        return toText(numberGroup(number).integerGroup(), false);
    }

    public String decimalText(Number number) {
        return toText(numberGroup(number).decimalGroup(), true);
    }

    public String intCurrencyText(Number number) {
        NumberGroup group = numberGroup(number);
        return lang.intCurrency(group.lastIntGroup());
    }

    public String decimalCurrencyText(Number number) {
        NumberGroup group = numberGroup(number);
        int[] last3Decimals = group.lastDecimalGroup();
        if (last3Decimals.length != 0) {
            return lang.decimalCurrency(group.lastDecimalGroup(), group.decimalLength());
        }
        return "";
    }

    public String originalInt(Number number) {
        return new DefaultNumber(number).intString();
    }

    public String originalDecimal(Number number) {
        return stringNumber(number).decimalString();
    }

    private StringNumber stringNumber(Number number) {
        StringNumber stringNumber = new DefaultNumber(number);
        return lang.hasSpecificCurrency() ? new RoundedNumber(stringNumber) : stringNumber;
    }

    private NumberGroup numberGroup(Number number) {
        return new NumberGroup(stringNumber(number));
    }

    private String toText(int[][] groups, boolean isDecimal) {
        StringJoiner result = new StringJoiner(" ");
        for (int i = 0; i < groups.length; i++) {
            int scale = groups.length - 1 - i;
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) {
                continue;
            }
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
        return digitGroupOrder.text(hundredText, tenText, unitText);
    }
}