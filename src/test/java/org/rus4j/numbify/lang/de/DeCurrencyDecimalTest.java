package org.rus4j.numbify.lang.de;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.CombinedText;
import org.rus4j.numbify.DecimalCurrencyText;
import org.rus4j.numbify.DecimalText;
import org.rus4j.numbify.DigitByDigitText;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.SolidText;
import org.rus4j.numbify.Text;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class DeCurrencyDecimalTest {
    @Test
    public void rubCurrencyDecimalTest() {
        Numbify de = new Numbify(
                new German(Currency.RUB),
                new DecimalCurrencyText(new DecimalText(new Text()))
        );

        assertThat(de.toText(0.01)).isEqualTo("eine Kopeke");
        assertThat(de.toText(0.02)).isEqualTo("zwei Kopeke");
        assertThat(de.toText(0.1)).isEqualTo("zehn Kopeke");
        assertThat(de.toText(0.10)).isEqualTo("zehn Kopeke");
        assertThat(de.toText(0.1000000000009)).isEqualTo("zehn Kopeke");
        assertThat(de.toText(0.00001)).isEqualTo("null Kopeke");
    }

    @Test
    public void usdCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.USD),
                new DecimalCurrencyText(new DecimalText(new Text()))
        );

        assertThat(de.toText(0.01)).isEqualTo("ein Cent");
        assertThat(de.toText(0.02)).isEqualTo("zwei Cent");
        assertThat(de.toText(0.1)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.10)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.100000009)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.0001)).isEqualTo("null Cent");
    }

    @Test
    public void eurCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.EUR),
                new DecimalCurrencyText(new DecimalText(new Text()))
        );

        assertThat(de.toText(0.01)).isEqualTo("ein Cent");
        assertThat(de.toText(0.02)).isEqualTo("zwei Cent");
        assertThat(de.toText(0.1)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.10)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.100000009)).isEqualTo("zehn Cent");
        assertThat(de.toText(0.0001)).isEqualTo("null Cent");
    }

    @Test
    public void numberCurrencyTest() {
        Numbify de = new Numbify(
                new German(Currency.NUMBER, "und"),
                new CombinedText(
                        new IntCurrencyText(new IntText(new SolidText())),
                        new DecimalCurrencyText(new DecimalText(new SolidText()))
                )
        );

        assertThat(de.toText(0.01)).isEqualTo("null und eins Hundertstel");
        assertThat(de.toText(0.02)).isEqualTo("null und zwei Hundertstel");
        assertThat(de.toText(0.1)).isEqualTo("null und eins Zehntel");
        assertThat(de.toText(0.10)).isEqualTo("null und eins Zehntel");
        assertThat(de.toText(0.100009)).isEqualTo("null und einhunderttausendneun Millionstel");
        assertThat(de.toText(0.0001)).isEqualTo("null und eins Zehntausendstel");
        // TODO Very specific and hard to maintain case. Won't be fixed?
        // assertThat(de.toText(1.01)).isEqualTo("ein und ein Hundertstel");
    }

    @Test
    public void numberCurrencyKommaTest() {
        Numbify de = new Numbify(
                new German(Currency.NUMBER),
                new CombinedText(
                        new IntCurrencyText(new IntText(new SolidText())),
                        new DecimalText(new DigitByDigitText())
                )
        );

        assertThat(de.toText(0.01)).isEqualTo("null Komma null eins");
        assertThat(de.toText(0.02)).isEqualTo("null Komma null zwei");
        assertThat(de.toText(100.10)).isEqualTo("einhundert Komma eins");
        assertThat(de.toText(1.01)).isEqualTo("eins Komma null eins");
        assertThat(de.toText(0.100009)).isEqualTo("null Komma eins null null null null neun");
    }
}
