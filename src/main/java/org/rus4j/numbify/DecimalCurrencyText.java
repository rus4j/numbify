package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class DecimalCurrencyText implements NumberText {
    private final NumberText numberText;

    public DecimalCurrencyText(NumberText numberText) {
        this.numberText = numberText;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String decimalText = numberText.toText(number, language);
        int[] last3Decimals = lastDecimalGroup(number);
        String decimalCurrencyText = "";
        if (last3Decimals.length != 0) {
            decimalCurrencyText = language.decimalCurrency(last3Decimals, number.decimalString().length());
        }
        if (!decimalCurrencyText.isEmpty()) {
            return decimalText + " " + decimalCurrencyText;
        }
        return decimalText;
    }

    private int[] lastDecimalGroup(StringNumber number) {
        int[][] decimalGroup = new NumberGroup(number.decimalString()).group();
        if (decimalGroup.length != 0) {
            return decimalGroup[decimalGroup.length - 1];
        }
        return new int[]{};
    }
}
