package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Russian;

import static org.assertj.core.api.Assertions.assertThat;

class NumbifyRussianTest {

    @Test
    public void test1() {
        Numbify ru = new NumbifyBuilder().language(new Russian()).build();
        assertThat(ru.toText(1)).isEqualTo("один");
        assertThat(ru.toText(12)).isEqualTo("двенадцать");
        assertThat(ru.toText(123)).isEqualTo("сто двадцать три");
        assertThat(ru.toText(1_234)).isEqualTo("одна тысяча двести тридцать четыре");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцать тысяч триста сорок пять");
        assertThat(ru.toText(123_456)).isEqualTo("сто двадцать три тысячи четыреста пятьдесят шесть");
        assertThat(ru.toText(1_234_567)).isEqualTo("один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцать миллионов триста сорок пять тысяч шестьсот семьдесят восемь");
        assertThat(ru.toText(123_456_789)).isEqualTo("сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("один миллиард двести тридцать четыре миллиона пятьсот шестьдесят семь тысяч восемьсот девяносто");

        assertThat(ru.toText(100)).isEqualTo("сто");
        assertThat(ru.toText(101)).isEqualTo("сто один");
        assertThat(ru.toText(1_001)).isEqualTo("одна тысяча один");
        assertThat(ru.toText(100_000)).isEqualTo("сто тысяч");
        assertThat(ru.toText(1_000_001)).isEqualTo("один миллион один");
    }
}