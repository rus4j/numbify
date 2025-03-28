package org.rus4j.numbify;

public class DecimalOriginalText implements NumberText {

    @Override
    public String text(NumberGroup group, Language lang) {
        return group.originalDecimal(lang.hasSpecificCurrency());
    }
}
