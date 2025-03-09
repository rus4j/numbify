package org.rus4j.numbify.lang.ru;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class RussianCurrencyTest {

    @Test
    public void rubNominativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("один рубль");
        assertThat(ru.toText(3)).isEqualTo("три рубля");
        assertThat(ru.toText(100)).isEqualTo("сто рублей");
    }

    @Test
    public void usdNominativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("один доллар");
        assertThat(ru.toText(3)).isEqualTo("три доллара");
        assertThat(ru.toText(100)).isEqualTo("сто долларов");
    }

    @Test
    public void eurNominativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одно евро");
        assertThat(ru.toText(3)).isEqualTo("три евро");
        assertThat(ru.toText(100)).isEqualTo("сто евро");
    }

    @Test
    public void rubGenitiveTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.GENITIVE, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одного рубля");
        assertThat(ru.toText(3)).isEqualTo("трёх рублей");
        assertThat(ru.toText(100)).isEqualTo("ста рублей");
    }

    @Test
    public void usdGenitiveTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.GENITIVE, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одного доллара");
        assertThat(ru.toText(3)).isEqualTo("трёх долларов");
        assertThat(ru.toText(100)).isEqualTo("ста долларов");
    }

    @Test
    public void eurGenitiveTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.GENITIVE, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одного евро");
        assertThat(ru.toText(3)).isEqualTo("трёх евро");
        assertThat(ru.toText(100)).isEqualTo("ста евро");
    }

    @Test
    public void rubAccusativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.ACCUSATIVE, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("один рубль");
        assertThat(ru.toText(3)).isEqualTo("три рубля");
        assertThat(ru.toText(100)).isEqualTo("сто рублей");
    }

    @Test
    public void usdAccusativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.ACCUSATIVE, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("один доллар");
        assertThat(ru.toText(3)).isEqualTo("три доллара");
        assertThat(ru.toText(100)).isEqualTo("сто долларов");
    }

    @Test
    public void eurAccusativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.ACCUSATIVE, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одно евро");
        assertThat(ru.toText(3)).isEqualTo("три евро");
        assertThat(ru.toText(100)).isEqualTo("сто евро");
    }

    @Test
    public void rubDativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.DATIVE, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одному рублю");
        assertThat(ru.toText(3)).isEqualTo("трём рублям");
        assertThat(ru.toText(100)).isEqualTo("ста рублям");
    }

    @Test
    public void usdDativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.DATIVE, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одному доллару");
        assertThat(ru.toText(3)).isEqualTo("трём долларам");
        assertThat(ru.toText(100)).isEqualTo("ста долларам");
    }

    @Test
    public void eurDativeTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.DATIVE, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одному евро");
        assertThat(ru.toText(3)).isEqualTo("трём евро");
        assertThat(ru.toText(100)).isEqualTo("ста евро");
    }

    @Test
    public void rubInstrumentalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.INSTRUMENTAL, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одним рублём");
        assertThat(ru.toText(3)).isEqualTo("тремя рублями");
        assertThat(ru.toText(100)).isEqualTo("ста рублями");
    }

    @Test
    public void usdInstrumentalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.INSTRUMENTAL, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одним долларом");
        assertThat(ru.toText(3)).isEqualTo("тремя долларами");
        assertThat(ru.toText(100)).isEqualTo("ста долларами");
    }

    @Test
    public void eurInstrumentalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.INSTRUMENTAL, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одним евро");
        assertThat(ru.toText(3)).isEqualTo("тремя евро");
        assertThat(ru.toText(100)).isEqualTo("ста евро");
    }

    @Test
    public void rubPrepositionalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.PREPOSITIONAL, Currency.RUB)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одном рубле");
        assertThat(ru.toText(3)).isEqualTo("трёх рублях");
        assertThat(ru.toText(100)).isEqualTo("ста рублях");
    }

    @Test
    public void usdPrepositionalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.PREPOSITIONAL, Currency.USD)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одном долларе");
        assertThat(ru.toText(3)).isEqualTo("трёх долларах");
        assertThat(ru.toText(100)).isEqualTo("ста долларах");
    }

    @Test
    public void eurPrepositionalTest() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.PREPOSITIONAL, Currency.EUR)
                .build();

        assertThat(ru.toText(1)).isEqualTo("одном евро");
        assertThat(ru.toText(3)).isEqualTo("трёх евро");
        assertThat(ru.toText(100)).isEqualTo("ста евро");
    }
}