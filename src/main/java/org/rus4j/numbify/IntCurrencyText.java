package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class IntCurrencyText implements NumberText {
    private final NumberText numberText;

    public IntCurrencyText(NumberText numberText) {
        this.numberText = numberText;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String intText = numberText.toText(number, language);
        NumberGroup numberGroup = new NumberGroup(number);
        String currencyText = language.intCurrency(numberGroup.lastIntGroup());
        if (!currencyText.isEmpty()) {
            return intText + " " + currencyText;
        }
        return intText;
    }
}
