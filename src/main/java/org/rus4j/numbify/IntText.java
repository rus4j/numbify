package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class IntText implements NumberText {
    private final Text text;

    public IntText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        return text.toIntText(number, language);
    }
}
