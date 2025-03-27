package org.rus4j.numbify;

public class Numbify {

    private final Language lang;
    private final NumberText intText;
    private final DelimiterText delimiterText;
    private final NumberText decimalText;

    public Numbify(
            Language lang,
            NumberText intText,
            NumberText decimalText,
            DelimiterText delimiterText
    ) {
        this.lang = lang;
        this.intText = intText;
        this.decimalText = decimalText;
        this.delimiterText = delimiterText;
    }

    public String toText(Number number) {
        NumberGroup group = new NumberGroup(number);
        String integer = intText.text(group, lang);
        String delimiter = delimiterText.text(lang);
        String decimal = decimalText.text(group, lang);

        if (!delimiter.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + delimiter + " " + decimal;
        }
        if (delimiter.isEmpty() && !decimal.isEmpty()) {
            return integer + " " + decimal;
        }
        return integer;
    }
}