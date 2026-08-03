package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class NegativeSignText implements NumberText {
    private final NumberText numberText;
    private final String customNegativeSignText;

    public NegativeSignText(String customNegativeSignText, NumberText numberText) {
        this.numberText = numberText;
        this.customNegativeSignText = customNegativeSignText;
    }

    public NegativeSignText(NumberText numberText) {
        this("", numberText);
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String text = numberText.toText(number, language);
        if (number.isNegative()) {
            String negativeSign = customNegativeSignText.isEmpty() ? language.negativeSign() : customNegativeSignText;
            return negativeSign + text.substring(1);
        }
        return text;
    }
}
