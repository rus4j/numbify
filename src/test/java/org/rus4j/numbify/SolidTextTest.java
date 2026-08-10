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

    @Test
    public void solidIntWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .solidInt()
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundredtwenty-three dollars twelve cents");
    }

    @Test
    public void solidDecimalWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.NUMBER)
                .solidDecimal()
                .build();
        assertThat(en.toText(123.123)).isEqualTo("one hundred twenty-three one hundredtwenty-three thousandths");
    }

    @Test
    public void customIntTextEngineWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("custom dollars twelve cents");
    }

    @Test
    public void customDecimalTextEngineWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundred twenty-three dollars custom cents");
    }

    @Test
    public void severalIntTextEnginesInARowWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitInt()
                .solidInt()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("custom dollars twelve cents");
    }

    @Test
    public void severalDecimalTextEnginesInARowWithBuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitDecimal()
                .solidDecimal()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundred twenty-three dollars custom cents");
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
