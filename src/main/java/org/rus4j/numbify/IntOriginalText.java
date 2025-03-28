package org.rus4j.numbify;

public class IntOriginalText implements NumberText {

    @Override
    public String text(NumberGroup group, Language lang) {
        return group.originalInt();
    }
}
