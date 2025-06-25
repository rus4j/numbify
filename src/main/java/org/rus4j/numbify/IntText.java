package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class IntText implements NumberText {
    private final TextEngine text;

    public IntText(TextEngine text) {
        this.text = text;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        String numText = text.toText(number.intString(), language, false);
        return number.isNegative() ? "- " + numText : numText;
    }
}
