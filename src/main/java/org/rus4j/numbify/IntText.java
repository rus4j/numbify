package org.rus4j.numbify;

public class IntText implements Numbify {
    private final Text text;

    public IntText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(Number number) {
        return text.intText(number);
    }
}
