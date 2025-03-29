package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.DefaultNumber;
import org.rus4j.numbify.number.RoundedNumber;
import org.rus4j.numbify.number.StringNumber;

public class CombinedText implements Numbify {

    private final Language lang;
    private final NumberText intText;
    private final DelimiterText delimiterText;
    private final NumberText decimalText;

    public CombinedText(
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

    @Override
    public String toText(Number number) {
        StringNumber stringNumber = new DefaultNumber(number);
        stringNumber = lang.hasSpecificCurrency() ? new RoundedNumber(stringNumber) : stringNumber;
        NumberGroup group = new NumberGroup(stringNumber);
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
