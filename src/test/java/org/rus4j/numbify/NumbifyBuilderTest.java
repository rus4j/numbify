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
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .digitByDigitInt()
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one two three dollars twelve cents");
    }

    @Test
    void solidIntTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .solidInt()
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one hundredtwenty-three dollars twelve cents");
    }

    @Test
    void customIntTextEngineTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("custom dollars twelve cents");
    }

    @Test
    void digitByDigitDecimalTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .digitByDigitDecimal()
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one hundred twenty-three dollars one two cents");
    }

    @Test
    void solidDecimalTest() {
        // Arrange
        double value = 123.123;

        Numbify sut = new NumbifyBuilder()
                .english(Currency.NUMBER)
                .solidDecimal()
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one hundred twenty-three one hundredtwenty-three thousandths");
    }

    @Test
    void customDecimalTextEngineTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one hundred twenty-three dollars custom cents");
    }

    @Test
    void severalIntTextEnginesInARowTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .digitByDigitInt()
                .solidInt()
                .customIntTextEngine((number, lang, isDecimal) -> "custom")
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("custom dollars twelve cents");
    }

    @Test
    void severalDecimalTextEnginesInARowTest() {
        // Arrange
        double value = 123.12;

        Numbify sut = new NumbifyBuilder()
                .english()
                .digitByDigitDecimal()
                .solidDecimal()
                .customDecimalTextEngine((number, lang, isDecimal) -> "custom")
                .build();

        // Act
        String actual = sut.toText(value);

        // Assert
        assertThat(actual).isEqualTo("one hundred twenty-three dollars custom cents");
    }
}
