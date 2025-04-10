package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class CapitalizedText implements NumberText {
    private final NumberText numberText;

    public CapitalizedText(NumberText numberText) {
        this.numberText = numberText;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        char[] chars = numberText.toText(number, language).toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars, 0, chars.length);
    }
}
