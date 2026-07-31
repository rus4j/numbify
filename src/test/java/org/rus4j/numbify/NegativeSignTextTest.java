package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.de.German;
import org.rus4j.numbify.lang.en.English;

import static org.assertj.core.api.Assertions.assertThat;

class NegativeSignTextTest {

    @Test
    public void negativeSignTest() {
        Numbify en = new NumbifyBuilder().english(Currency.USD).negativeSign().build();
        assertThat(en.toText(-123)).isEqualTo("negative one hundred twenty-three dollars");
    }

    @Test
    public void negativeRussianSignTest() {
        Numbify en = new NumbifyBuilder().russian(Currency.RUB).negativeSign().build();
        assertThat(en.toText(-123)).isEqualTo("минус сто двадцать три рубля");
    }

    @Test
    public void negativeGermanSignTest() {
        Numbify de = new Numbify(
                new German(Currency.EUR),
                new NegativeSignText(new IntText(new SolidText()))
        );
        assertThat(de.toText(-123)).isEqualTo("minus einhundertdreiundzwanzig");
    }

    @Test
    public void negativeSignWithCapitalizeTest() {
        Numbify en = new NumbifyBuilder().english(Currency.USD).capitalize().negativeSign().build();
        assertThat(en.toText(-123)).isEqualTo("Negative one hundred twenty-three dollars");
    }

    @Test
    public void negativeNumberWithCapitalizeTest() {
        Numbify en = new NumbifyBuilder().english(Currency.USD).capitalize().build();
        assertThat(en.toText(-123)).isEqualTo("- One hundred twenty-three dollars");
    }

    @Test
    public void positiveNumberTest() {
        Numbify en = new NumbifyBuilder().english(Currency.USD).negativeSign().build();
        assertThat(en.toText(123)).isEqualTo("one hundred twenty-three dollars");
    }

    @Test
    public void customNegativeSignTest() {
        Numbify en = new Numbify(
                new English(Currency.USD),
                new NegativeSignText("minus", new IntCurrencyText(new IntText(new Text())))
        );
        assertThat(en.toText(-123)).isEqualTo("minus one hundred twenty-three dollars");
    }

    @Test
    public void negativeSignWithIntOriginalTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new NegativeSignText(
                        new IntOriginalText()
                )
        );
        assertThat(en.toText(-12.123)).isEqualTo("negative 12");
    }

    @Test
    public void negativeSignWithDecimalOriginalTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new NegativeSignText(
                        new DecimalOriginalText()
                )
        );
        assertThat(en.toText(-12.123)).isEqualTo("negative 123");
    }

    @Test
    public void negativeSignWithEmptyDecimalOriginalTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new NegativeSignText(new DecimalOriginalText())
        );

        assertThat(en.toText(-123)).isEmpty();
    }
}