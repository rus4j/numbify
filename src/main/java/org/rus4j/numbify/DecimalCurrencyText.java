package org.rus4j.numbify;

public class DecimalCurrencyText implements NumberText {
    private final Text text;

    public DecimalCurrencyText(Text text) {
        this.text = text;
    }

    @Override
    public String text(NumberGroup group, Language lang) {
        String decimalText = text.decimalText(group, lang);
        int[] last3Decimals = group.lastDecimalGroup();
        if (last3Decimals.length != 0) {
            return decimalText + " " + lang.decimalCurrency(last3Decimals, group.decimalLength());
        }
        return decimalText;
    }
}
