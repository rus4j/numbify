package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class CombinedText implements NumberText {
    private final NumberText intText;
    private final NumberText decimalText;

    public CombinedText(NumberText intText, NumberText decimalText) {
        this.intText = intText;
        this.decimalText = decimalText;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String integer = intText.toText(number, language);
        String decimal = decimalText.toText(number, language);
        String decimalSeparator = language.decimalSeparator();

        if (!decimalSeparator.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + decimalSeparator + " " + decimal;
        }
        if (decimalSeparator.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + decimal;
        }
        return integer;
    }
}
