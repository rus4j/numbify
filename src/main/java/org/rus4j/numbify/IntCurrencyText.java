package org.rus4j.numbify;

public class IntCurrencyText implements Numbify {
    private final Numbify numberText;
    private final Text text;

    public IntCurrencyText(Numbify numberText, Text text) {
        this.numberText = numberText;
        this.text = text;
    }

    public String toText(Number number) {
        String intText = numberText.toText(number);
        String currencyText = text.intCurrencyText(number);
        if (!currencyText.isEmpty()) {
            return intText + " " + currencyText;
        }
        return intText;
    }
}
