package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author vodobryshkin
 * @since 31.07.2026 13:29
 */
public class NumbifyBuilderTest {
    @Test
    void digitByDigitIntTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitInt()
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one two three dollars twelve cents");
    }

    @Test
    void solidIntTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .solidInt()
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundredtwenty-three dollars twelve cents");
    }

    @Test
    void customIntTextEngineTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("custom dollars twelve cents");
    }

    @Test
    void digitByDigitDecimalTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitDecimal()
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundred twenty-three dollars one two cents");
    }

    @Test
    void solidDecimalTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.NUMBER)
                .solidDecimal()
                .build();
        assertThat(en.toText(123.123)).isEqualTo("one hundred twenty-three one hundredtwenty-three thousandths");
    }

    @Test
    void customDecimalTextEngineTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundred twenty-three dollars custom cents");
    }

    @Test
    void severalIntTextEnginesInARowTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitInt()
                .solidInt()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("custom dollars twelve cents");
    }

    @Test
    void severalDecimalTextEnginesInARowTest() {
        Numbify en = new NumbifyBuilder()
                .english()
                .digitByDigitDecimal()
                .solidDecimal()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();
        assertThat(en.toText(123.12)).isEqualTo("one hundred twenty-three dollars custom cents");
    }
}
