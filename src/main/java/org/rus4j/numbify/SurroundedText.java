package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class SurroundedText implements NumberText {
    private final NumberText numberText;
    private final String prefix;
    private final String suffix;

    public SurroundedText(NumberText numberText, String prefix, String suffix) {
        this.numberText = numberText;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String text = numberText.toText(number, language);
        return text.isEmpty() ? "" : prefix + text + suffix;
    }
}