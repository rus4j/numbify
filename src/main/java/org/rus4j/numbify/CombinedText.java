package org.rus4j.numbify;

public class CombinedText implements Numbify {

    private final Numbify intText;
    private final Numbify decimalText;
    private final String decimalSeparator;

    public CombinedText(
            Numbify intText,
            Numbify decimalText,
            String decimalSeparator
    ) {
        this.intText = intText;
        this.decimalText = decimalText;
        this.decimalSeparator = decimalSeparator;
    }

    @Override
    public String toText(Number number) {
        String integer = intText.toText(number);
        String decimal = decimalText.toText(number);

        if (!decimalSeparator.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + decimalSeparator + " " + decimal;
        }
        if (decimalSeparator.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + decimal;
        }
        return integer;
    }
}
