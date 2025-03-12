package org.rus4j.numbify.lang.en;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class EnglishCurrencyDecimalTest {
    @Test
    public void rubCurrencyDecimalTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.RUB)
                .showIntegerCurrency(true)
                .showDecimalCurrency(true)
                .build();

        assertThat(en.toText(0.01)).isEqualTo("zero rubles one kopeck");
        assertThat(en.toText(0.02)).isEqualTo("zero rubles two kopecks");
        assertThat(en.toText(0.1)).isEqualTo("zero rubles ten kopecks");
        assertThat(en.toText(0.10)).isEqualTo("zero rubles ten kopecks");
        assertThat(en.toText(0.100000009)).isEqualTo("zero rubles ten kopecks");
        assertThat(en.toText(0.0001)).isEqualTo("zero rubles zero kopecks");
    }

    @Test
    public void usdCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.USD)
                .showIntegerCurrency(true)
                .showDecimalCurrency(true)
                .build();

        assertThat(en.toText(0.01)).isEqualTo("zero dollars one cent");
        assertThat(en.toText(0.02)).isEqualTo("zero dollars two cents");
        assertThat(en.toText(0.1)).isEqualTo("zero dollars ten cents");
        assertThat(en.toText(0.10)).isEqualTo("zero dollars ten cents");
        assertThat(en.toText(0.100000009)).isEqualTo("zero dollars ten cents");
        assertThat(en.toText(0.0001)).isEqualTo("zero dollars zero cents");
    }

    @Test
    public void eurCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.EUR)
                .showIntegerCurrency(true)
                .showDecimalCurrency(true)
                .build();

        assertThat(en.toText(0.01)).isEqualTo("zero euros one cent");
        assertThat(en.toText(0.02)).isEqualTo("zero euros two cents");
        assertThat(en.toText(0.1)).isEqualTo("zero euros ten cents");
        assertThat(en.toText(0.10)).isEqualTo("zero euros ten cents");
        assertThat(en.toText(0.100000009)).isEqualTo("zero euros ten cents");
        assertThat(en.toText(0.0001)).isEqualTo("zero euros zero cents");
    }

    @Test
    public void numberCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.NUMBER)
                .showIntegerCurrency(true)
                .showDecimalCurrency(true)
                .build();


        assertThat(en.toText(0.01)).isEqualTo("zero and one hundredths");
        assertThat(en.toText(0.02)).isEqualTo("zero and two hundredths");
        assertThat(en.toText(0.1)).isEqualTo("zero and one tenths");
        assertThat(en.toText(0.10)).isEqualTo("zero and one tenths");
        assertThat(en.toText(0.001)).isEqualTo("zero and one thousandths");
        assertThat(en.toText(0.0001)).isEqualTo("zero and one ten thousandths");
        assertThat(en.toText(0.00001)).isEqualTo("zero and one hundred thousandths");
        assertThat(en.toText(0.000001)).isEqualTo("zero and one millionth");
        assertThat(en.toText(0.1000009)).isEqualTo("zero and one million nine ten millionth");
    }
}
