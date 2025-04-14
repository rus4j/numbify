package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class NegativeSignText implements NumberText {
    private final NumberText numberText;

    public NegativeSignText(NumberText numberText) {
        this.numberText = numberText;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String text = numberText.toText(number, language);
        if (number.isNegative()) {
            return language.minusSign() + text.substring(1);
        }
        return text;
    }
}
