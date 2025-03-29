package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class OriginalNumberTest {

    @Test
    public void originalIntTest() {
        Numbify ru = new NumbifyBuilder().russian(Currency.RUB)
                .originalInt().build();
        Numbify en = new NumbifyBuilder().english(Currency.USD)
                .originalInt().build();

        assertThat(ru.toText(10.23)).isEqualTo("10 рублей двадцать три копейки");
        assertThat(ru.toText(0.23)).isEqualTo("0 рублей двадцать три копейки");

        assertThat(en.toText(10.5)).isEqualTo("10 dollars fifty cents");
        assertThat(en.toText(.5)).isEqualTo("0 dollars fifty cents");
    }

    @Test
    public void originalDecimalTest() {
        Numbify ru = new NumbifyBuilder().russian(Currency.RUB)
                .originalDecimal().build();
        Numbify en = new NumbifyBuilder().english(Currency.USD)
                .originalDecimal().build();

        assertThat(ru.toText(10.23)).isEqualTo("десять рублей 23 копейки");
        assertThat(ru.toText(0)).isEqualTo("ноль рублей");
        assertThat(ru.toText(0.1)).isEqualTo("ноль рублей 10 копеек");

        assertThat(en.toText(10.5)).isEqualTo("ten dollars 50 cents");
        assertThat(en.toText(1)).isEqualTo("one dollar");
        assertThat(en.toText(1.40999)).isEqualTo("one dollar 40 cents");
    }
}
