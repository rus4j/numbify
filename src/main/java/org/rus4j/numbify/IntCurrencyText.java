package org.rus4j.numbify;

public class IntCurrencyText implements NumberText {
    private final Text text;

    public IntCurrencyText(Text text) {
        this.text = text;
    }

    public String text(NumberGroup group, Language lang) {
        String intText = text.intText(group, lang);
        String currencyText = lang.intCurrency(group.lastIntGroup());
        if (!currencyText.isEmpty()) {
            return intText + " " + currencyText;
        }
        return intText;
    }

}
