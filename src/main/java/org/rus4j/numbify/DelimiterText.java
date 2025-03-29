package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;

public class DelimiterText {

    public String text(Language lang) {
        if (!lang.numberPartsDelimiter().isEmpty()) {
            return lang.numberPartsDelimiter();
        }
        return "";
    }
}
