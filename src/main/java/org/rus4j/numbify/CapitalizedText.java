package org.rus4j.numbify;

public class CapitalizedText implements Numbify {
    private final Numbify numbify;

    public CapitalizedText(Numbify numbify) {
        this.numbify = numbify;
    }

    @Override
    public String toText(Number number) {
        char[] chars = numbify.toText(number).toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars, 0, chars.length);
    }
}
