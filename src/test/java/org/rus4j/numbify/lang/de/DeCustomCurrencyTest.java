package org.rus4j.numbify.lang.de;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.CombinedText;
import org.rus4j.numbify.DecimalCurrencyText;
import org.rus4j.numbify.DecimalText;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.Text;
import org.rus4j.numbify.lang.Gender;
import org.rus4j.numbify.lang.en.EurCodeText;
import org.rus4j.numbify.lang.en.UsdCodeText;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeCustomCurrencyTest {
    @Test
    public void testDeCustomCurrency() {
        Numbify numbify = new Numbify(
                new German(new Gender[]{Gender.MALE, Gender.MALE}, new UsdCodeText(), ""),
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalText(new Text()))
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("zehn USD null cents");
        assertThat(numbify.toText(10.01)).isEqualTo("zehn USD ein cent");
    }

    @Test
    public void testEnglishEurCodeCurrency() {
        Numbify numbify = new Numbify(
                new German(new Gender[]{Gender.MALE, Gender.MALE}, new EurCodeText(), ""),
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalText(new Text()))
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("zehn EUR null cents");
        assertThat(numbify.toText(10.01)).isEqualTo("zehn EUR ein cent");
    }
}
