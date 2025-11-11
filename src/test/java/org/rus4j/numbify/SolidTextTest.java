package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.Russian;

import static org.assertj.core.api.Assertions.assertThat;

public class SolidTextTest {
    @Test
    public void fullSolidEnglishTest() {
        Numbify solid = new Numbify(
                new CustomEnglish(Currency.NUMBER),
                new IntText(new CustomSolid())
        );

        assertThat(solid.toText(123)).isEqualTo("onehundredtwentythree");
    }

    @Test
    public void solidRussianTest() {
        Numbify solid = new Numbify(
                new CustomRussian(Currency.NUMBER),
                new IntText(new SolidText())
        );

        assertThat(solid.toText(123)).isEqualTo("стодвадцатьтри");
    }
}

class CustomEnglish extends English {
    public CustomEnglish(Currency currency) {
        super(currency);
    }

    @Override
    public DigitGroupOrder textOrder() {
        return new ForwardOrder("");
    }
}

class CustomRussian extends Russian {
    public CustomRussian(Currency currency) {
        super(currency);
    }

    @Override
    public DigitGroupOrder textOrder() {
        return new ForwardOrder("");
    }
}

class CustomSolid implements TextEngine {
    private final Text text = new Text("");

    @Override
    public String toText(String number, Language lang, boolean isDecimal) {
        String result = text.toText(number, lang, isDecimal);
        return result.replaceAll("\\s", "");
    }
}
