package org.rus4j.numbify.lang.en;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class EnglishCurrencyTest {

    @Test
    public void rubCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.RUB)
                .hideDecimalCurrency()
                .build();

        assertThat(en.toText(100)).isEqualTo("one hundred rubles");
        assertThat(en.toText(1)).isEqualTo("one ruble");
        assertThat(en.toText(990_123)).isEqualTo("nine hundred ninety thousand one hundred twenty three rubles");
    }

    @Test
    public void usdCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.USD)
                .hideDecimalCurrency()
                .build();

        assertThat(en.toText(100)).isEqualTo("one hundred dollars");
        assertThat(en.toText(1)).isEqualTo("one dollar");
        assertThat(en.toText(99_123)).isEqualTo("ninety nine thousand one hundred twenty three dollars");
    }

    @Test
    public void eurCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.EUR)
                .hideDecimalCurrency()
                .build();

        assertThat(en.toText(100)).isEqualTo("one hundred euros");
        assertThat(en.toText(1)).isEqualTo("one euro");
        assertThat(en.toText(99_123)).isEqualTo("ninety nine thousand one hundred twenty three euros");
    }
}
