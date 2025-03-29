package org.rus4j.numbify.lang.en;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class EnglishTest {

    @Test
    public void test() {
        Numbify en = new NumbifyBuilder().english().hideIntCurrency().hideDecimalCurrency().build();
        assertThat(en.toText(0)).isEqualTo("zero");
        assertThat(en.toText(1)).isEqualTo("one");
        assertThat(en.toText(12)).isEqualTo("twelve");
        assertThat(en.toText(123)).isEqualTo("one hundred twenty three");
        assertThat(en.toText(1_234)).isEqualTo("one thousand two hundred thirty four");
        assertThat(en.toText(12_345)).isEqualTo("twelve thousand three hundred forty five");
        assertThat(en.toText(123_456)).isEqualTo("one hundred twenty three thousand four hundred fifty six");
        assertThat(en.toText(1_234_567)).isEqualTo("one million two hundred thirty four thousand five hundred sixty seven");
        assertThat(en.toText(12_345_678)).isEqualTo("twelve million three hundred forty five thousand six hundred seventy eight");
        assertThat(en.toText(123_456_789)).isEqualTo("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine");
        assertThat(en.toText(1_234_567_890)).isEqualTo("one billion two hundred thirty four million five hundred sixty seven thousand eight hundred ninety");

        assertThat(en.toText(100)).isEqualTo("one hundred");
        assertThat(en.toText(101)).isEqualTo("one hundred one");
        assertThat(en.toText(1_001)).isEqualTo("one thousand one");
        assertThat(en.toText(100_000)).isEqualTo("one hundred thousand");
        assertThat(en.toText(1_000_001)).isEqualTo("one million one");

        assertThat(en.toText(1_200)).isEqualTo("one thousand two hundred");
        assertThat(en.toText(1_020)).isEqualTo("one thousand twenty");

        assertThat(en.toText(Long.MAX_VALUE))
                .isEqualTo("nine quintillion " +
                        "two hundred twenty three quadrillion " +
                        "three hundred seventy two trillion " +
                        "thirty six billion " +
                        "eight hundred fifty four million " +
                        "seven hundred seventy five thousand " +
                        "eight hundred seven"
                );
    }

    @Test
    public void numberTest() {
        Numbify en = new NumbifyBuilder().english(Currency.NUMBER).build();
        assertThat(en.toText(123)).isEqualTo("one hundred twenty three");
        assertThat(en.toText(123.1)).isEqualTo("one hundred twenty three and one tenths");
    }
}
