package org.rus4j.numbify;

public class DecimalCurrencyText implements Numbify {
    private final Numbify numberText;
    private final Text text;

    public DecimalCurrencyText(Numbify numberText, Text text) {
        this.numberText = numberText;
        this.text = text;
    }

    @Override
    public String toText(Number number) {
        String decimalText = numberText.toText(number);
        String decimalCurrencyText = text.decimalCurrencyText(number);
        if (!decimalCurrencyText.isEmpty()) {
            return decimalText + " " + decimalCurrencyText;
        }
        return decimalText;
    }
}
