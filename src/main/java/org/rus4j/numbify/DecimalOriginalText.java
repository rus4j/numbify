package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class DecimalOriginalText implements NumberText {

    @Override
    public String toText(StringNumber number, Language language) {
        return number.decimalString();
    }
}
