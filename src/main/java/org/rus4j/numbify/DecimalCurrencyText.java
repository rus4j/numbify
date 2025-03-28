package org.rus4j.numbify;

public class DecimalCurrencyText implements NumberText {
    private final NumberText text;

    public DecimalCurrencyText(NumberText text) {
        this.text = text;
    }

    @Override
    public String text(NumberGroup group, Language lang) {
        String decimalText = text.text(group, lang);
        int[] last3Decimals = group.lastDecimalGroup(lang.hasSpecificCurrency());
        if (last3Decimals.length != 0) {
            return decimalText + " " + lang.decimalCurrency(last3Decimals, group.decimalLength());
        }
        return decimalText;
    }
}
