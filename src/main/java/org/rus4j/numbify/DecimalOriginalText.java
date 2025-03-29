package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;

public class DecimalOriginalText implements NumberText {

    @Override
    public String text(NumberGroup group, Language lang) {
        return group.originalDecimal();
    }
}
