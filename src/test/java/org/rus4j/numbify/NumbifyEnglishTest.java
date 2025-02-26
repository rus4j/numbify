package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.en.EnDeclension;
import org.rus4j.numbify.lang.en.English;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbifyEnglishTest {
    @Test
    public void test() {
        Numbify ru = new NumbifyBuilder().language(new English()).declension(EnDeclension.COMMON).build();
        assertThat(ru.toText(1)).isEqualTo("one");
        assertThat(ru.toText(12)).isEqualTo("twelve");
        assertThat(ru.toText(123)).isEqualTo("one hundred twenty three");
        assertThat(ru.toText(1_234)).isEqualTo("one thousand two hundred thirty four");
        assertThat(ru.toText(12_345)).isEqualTo("twelve thousand three hundred forty five");
        assertThat(ru.toText(123_456)).isEqualTo("one hundred twenty three thousand four hundred fifty six");
        assertThat(ru.toText(1_234_567)).isEqualTo("one million two hundred thirty four thousand five hundred sixty seven");
        assertThat(ru.toText(12_345_678)).isEqualTo("twelve million three hundred forty five thousand six hundred seventy eight");
        assertThat(ru.toText(123_456_789)).isEqualTo("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("one billion two hundred thirty four million five hundred sixty seven thousand eight hundred ninety");

        assertThat(ru.toText(100)).isEqualTo("one hundred");
        assertThat(ru.toText(101)).isEqualTo("one hundred one");
        assertThat(ru.toText(1_001)).isEqualTo("one thousand one");
        assertThat(ru.toText(100_000)).isEqualTo("one hundred thousand");
        assertThat(ru.toText(1_000_001)).isEqualTo("one million one");
    }
}
