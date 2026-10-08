package org.rus4j.numbify.lang.en;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import java.math.BigDecimal;

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
        assertThat(en.toText(11)).isEqualTo("eleven rubles");
        assertThat(en.toText(21)).endsWith("twenty-one rubles");
        assertThat(en.toText(101)).endsWith("one hundred one rubles");
        assertThat(en.toText(1001)).endsWith("one thousand one rubles");
        assertThat(en.toText(990_123)).isEqualTo("nine hundred ninety thousand one hundred twenty-three rubles");
    }

    @Test
    public void usdCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.USD)
                .hideDecimalCurrency()
                .build();

        assertThat(en.toText(100)).isEqualTo("one hundred dollars");
        assertThat(en.toText(1)).isEqualTo("one dollar");
        assertThat(en.toText(11)).isEqualTo("eleven dollars");
        assertThat(en.toText(21)).endsWith("twenty-one dollars");
        assertThat(en.toText(101)).endsWith("one hundred one dollars");
        assertThat(en.toText(1001)).endsWith("one thousand one dollars");
        assertThat(en.toText(99_123)).isEqualTo("ninety-nine thousand one hundred twenty-three dollars");
    }

    @Test
    public void eurCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.EUR)
                .hideDecimalCurrency()
                .build();

        assertThat(en.toText(100)).isEqualTo("one hundred euros");
        assertThat(en.toText(1)).isEqualTo("one euro");
        assertThat(en.toText(11)).isEqualTo("eleven euros");
        assertThat(en.toText(21)).endsWith("twenty-one euros");
        assertThat(en.toText(101)).endsWith("one hundred one euros");
        assertThat(en.toText(1001)).endsWith("one thousand one euros");
        assertThat(en.toText(99_123)).isEqualTo("ninety-nine thousand one hundred twenty-three euros");
    }

    @Test
    public void rubDecimalCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.RUB)
                .build();

        assertThat(en.toText(new BigDecimal("1.01"))).isEqualTo("one ruble one kopeck");
        assertThat(en.toText(new BigDecimal("1.11"))).isEqualTo("one ruble eleven kopecks");
        assertThat(en.toText(new BigDecimal("1.21"))).isEqualTo("one ruble twenty-one kopecks");
    }

    @Test
    public void usdDecimalCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.USD)
                .build();

        assertThat(en.toText(new BigDecimal("1.01"))).isEqualTo("one dollar one cent");
        assertThat(en.toText(new BigDecimal("1.11"))).isEqualTo("one dollar eleven cents");
        assertThat(en.toText(new BigDecimal("1.21"))).isEqualTo("one dollar twenty-one cents");
    }

    @Test
    public void eurDecimalCurrencyTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.EUR)
                .build();

        assertThat(en.toText(new BigDecimal("1.01"))).isEqualTo("one euro one cent");
        assertThat(en.toText(new BigDecimal("1.11"))).isEqualTo("one euro eleven cents");
        assertThat(en.toText(new BigDecimal("1.21"))).isEqualTo("one euro twenty-one cents");
    }

    @Test
    public void intCurrencySingleArgumentTest() {
        English standard = new English(Currency.USD);
        assertThat(standard.intCurrency(new int[]{0, 0, 1})).isEqualTo("dollar");
        assertThat(standard.intCurrency(new int[]{0, 0, 2})).isEqualTo("dollars");

        English custom = new English(new UsdCodeText());
        assertThat(custom.intCurrency(new int[]{0, 0, 1})).isEqualTo("USD");
    }
}
