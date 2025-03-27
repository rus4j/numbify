package org.rus4j.numbify;

public class DelimiterText {

    public String text(Language lang) {
        if (!lang.numberPartsDelimiter().isEmpty()) {
            return lang.numberPartsDelimiter();
        }
        return "";
    }
}
