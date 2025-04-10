package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class DecimalText implements NumberText {
    private final Text text;

    public DecimalText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(StringNumber number, Language language) {
        return text.toDecimalText(new NumberGroup(number).decimalGroup(), language);
    }
}
