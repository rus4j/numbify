package org.rus4j.numbify.lang.ru;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class RussianCurrencyDecimalTest {

    @Test
    public void rubNominativeDecimal() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.RUB)
                .build();

        assertThat(ru.toText(0.01)).isEqualTo("ноль рублей одна копейка");
        assertThat(ru.toText(0.02)).isEqualTo("ноль рублей две копейки");
        assertThat(ru.toText(0.05)).isEqualTo("ноль рублей пять копеек");
        assertThat(ru.toText(0.1)).isEqualTo("ноль рублей десять копеек");
        assertThat(ru.toText(0.10)).isEqualTo("ноль рублей десять копеек");
        assertThat(ru.toText(0.001)).isEqualTo("ноль рублей ноль копеек");
    }

    @Test
    public void usdNominativeDecimal() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.USD)
                .build();

        assertThat(ru.toText(0.01)).isEqualTo("ноль долларов один цент");
        assertThat(ru.toText(0.02)).isEqualTo("ноль долларов два цента");
        assertThat(ru.toText(0.05)).isEqualTo("ноль долларов пять центов");
        assertThat(ru.toText(0.1)).isEqualTo("ноль долларов десять центов");
        assertThat(ru.toText(0.10)).isEqualTo("ноль долларов десять центов");
        assertThat(ru.toText(0.001)).isEqualTo("ноль долларов ноль центов");
    }

    @Test
    public void eurNominativeDecimal() {
        Numbify ru = new NumbifyBuilder()
                .russian(RuDeclension.NOMINATIVE, Currency.EUR)
                .build();

        assertThat(ru.toText(0.01)).isEqualTo("ноль евро один цент");
        assertThat(ru.toText(0.02)).isEqualTo("ноль евро два цента");
        assertThat(ru.toText(0.05)).isEqualTo("ноль евро пять центов");
        assertThat(ru.toText(0.1)).isEqualTo("ноль евро десять центов");
        assertThat(ru.toText(0.10)).isEqualTo("ноль евро десять центов");
        assertThat(ru.toText(0.001)).isEqualTo("ноль евро ноль центов");
    }
}
