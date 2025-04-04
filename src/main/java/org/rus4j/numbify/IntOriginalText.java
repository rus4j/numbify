package org.rus4j.numbify;

public class IntOriginalText implements Numbify {
    private final Text text;

    public IntOriginalText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(Number number) {
        return text.originalInt(number);
    }
}
