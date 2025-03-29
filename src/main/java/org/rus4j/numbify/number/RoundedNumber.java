package org.rus4j.numbify.number;

public class RoundedNumber implements StringNumber {
    private final StringNumber number;
    private final int scale;

    public RoundedNumber(StringNumber number, int scale) {
        this.number = number;
        this.scale = scale;
    }

    public RoundedNumber(StringNumber number) {
        this(number, 2);
    }

    @Override
    public String intString() {
        return number.intString();
    }

    public String decimalString() {
        String decimalPart = number.decimalString();
        if (decimalPart.isEmpty()) return decimalPart;
        return round(decimalPart);
    }

    private String round(String decimalPart) {
        if (decimalPart.length() < scale) {
            return decimalPart + "0".repeat(scale - decimalPart.length());
        }
        return decimalPart.substring(0, scale);
    }
}