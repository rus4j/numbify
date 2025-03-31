package org.rus4j.numbify;

public class DecimalText implements Numbify {
    private final Text text;

    public DecimalText(Text text) {
        this.text = text;
    }

    @Override
    public String toText(Number number) {
        return text.decimalText(number);
    }
}
