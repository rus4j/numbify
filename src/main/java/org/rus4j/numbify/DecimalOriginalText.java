package org.rus4j.numbify;

public class DecimalOriginalText implements Numbify {
    private final Text text;

    public DecimalOriginalText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(Number number) {
        return text.originalDecimal(number);
    }
}
