package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.DefaultNumber;
import org.rus4j.numbify.number.RoundedNumber;
import org.rus4j.numbify.number.StringNumber;

/**
 * Base class the user usually interact with.
 * Does the main thing - convert number to text.
 */
public class Numbify {
    private final Language language;
    private final NumberText numberText;

    public Numbify(Language language, NumberText numberText) {
        this.language = language;
        this.numberText = numberText;
    }

    public String toText(Number number) {
        StringNumber stringNumber = new DefaultNumber(number);
        stringNumber = language.hasSpecificCurrency() ? new RoundedNumber(stringNumber) : stringNumber;
        return numberText.toText(stringNumber, language);
    }
}