package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;

public class SolidText implements TextEngine {
    private final Text text = new Text("");

    @Override
    public String toText(String number, Language lang, boolean isDecimal) {
        return text.toText(number, lang, isDecimal);
    }
}
