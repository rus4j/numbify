package org.rus4j.numbify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Stream.of(
            intText.text(group, lang),
            delimiterText.text(lang),
            decimalText.text(group, lang)
        )
            .filter(text -> text != null && !text.isEmpty())
            .collect(Collectors.joining(" "));
    }
}