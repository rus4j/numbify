package org.rus4j.numbify;

public class IntCurrencyText implements NumberText {
    private final NumberText text;

    public IntCurrencyText(NumberText text) {
        this.text = text;
    }

    public String text(NumberGroup group, Language lang) {
        String intText = text.text(group, lang);
        String currencyText = lang.intCurrency(group.lastIntGroup());
        if (!currencyText.isEmpty()) {
            return intText + " " + currencyText;
        }
        return intText;
    }

}
