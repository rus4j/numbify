package org.rus4j.numbify.lang.de;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.Text;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class DeCurrencyTest {

    @Test
    public void rubCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.RUB),
                new IntCurrencyText(new IntText(new Text()))
        );

        assertThat(de.toText(100)).isEqualTo("einhundert Rubel");
        assertThat(de.toText(1)).isEqualTo("ein Rubel");
    }

    @Test
    public void usdCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.USD),
                new IntCurrencyText(new IntText(new Text()))
        );

        assertThat(de.toText(100)).isEqualTo("einhundert Dollar");
        assertThat(de.toText(1)).isEqualTo("ein Dollar");
    }

    @Test
    public void eurCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.EUR),
                new IntCurrencyText(new IntText(new Text()))
        );

        assertThat(de.toText(100)).isEqualTo("einhundert Euro");
        assertThat(de.toText(1)).isEqualTo("ein Euro");
    }
}
