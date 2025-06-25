package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class DecimalText implements NumberText {
    private final TextEngine text;

    public DecimalText(TextEngine text) {
        this.text = text;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        return text.toText(number.decimalString(), language, true);
    }
}
