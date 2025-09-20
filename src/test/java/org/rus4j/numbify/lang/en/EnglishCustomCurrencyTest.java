package org.rus4j.numbify.lang.en;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.CombinedText;
import org.rus4j.numbify.DecimalCurrencyText;
import org.rus4j.numbify.DecimalText;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.Text;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EnglishCustomCurrencyTest {
    @Test
    public void testEnglishCustomCurrencyWithSeparator() {
        Numbify numbify = new Numbify(
                new English(new UsdCodeText(), "and"),
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalText(new Text()))
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("ten USD and zero cents");
    }

    @Test
    public void testEnglishCustomCurrency() {
        Numbify numbify = new Numbify(
                new English(new UsdCodeText()),
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalText(new Text()))
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("ten USD zero cents");
        assertThat(numbify.toText(10.01)).isEqualTo("ten USD one cent");
    }

    @Test
    public void testEnglishEurCodeCurrency() {
        Numbify numbify = new Numbify(
                new English(new EurCodeText()),
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalText(new Text()))
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("ten EUR zero cents");
        assertThat(numbify.toText(10.01)).isEqualTo("ten EUR one cent");
    }
}
