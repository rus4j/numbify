package org.rus4j.numbify.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.NumbifyBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonTest {

    @Test
    public void numberTypesTest() {
        Numbify ru = new NumbifyBuilder().russian().hideIntCurrency().hideDecimalCurrency().build();

        assertThat(ru.toText(12)).isEqualTo("двенадцать");
        assertThat(ru.toText(1.5)).isEqualTo("одна пять");
        assertThat(ru.toText(1.5f)).isEqualTo("одна пять");
        assertThat(ru.toText(Byte.MAX_VALUE)).isEqualTo("сто двадцать семь");
        assertThat(ru.toText(Short.MAX_VALUE)).isEqualTo("тридцать две тысячи семьсот шестьдесят семь");
        assertThat(ru.toText(Long.MAX_VALUE))
                .isEqualTo("девять квинтиллионов " +
                        "двести двадцать три квадриллиона " +
                        "триста семьдесят два триллиона " +
                        "тридцать шесть миллиардов " +
                        "восемьсот пятьдесят четыре миллиона " +
                        "семьсот семьдесят пять тысяч " +
                        "восемьсот семь");
        assertThat(ru.toText(new BigInteger("9223372036854775808")))
                .isEqualTo("девять квинтиллионов " +
                        "двести двадцать три квадриллиона " +
                        "триста семьдесят два триллиона " +
                        "тридцать шесть миллиардов " +
                        "восемьсот пятьдесят четыре миллиона " +
                        "семьсот семьдесят пять тысяч " +
                        "восемьсот восемь");
        assertThat(ru.toText(new BigDecimal("9223372036854775808.12")))
                .isEqualTo("девять квинтиллионов " +
                        "двести двадцать три квадриллиона " +
                        "триста семьдесят два триллиона " +
                        "тридцать шесть миллиардов " +
                        "восемьсот пятьдесят четыре миллиона " +
                        "семьсот семьдесят пять тысяч " +
                        "восемьсот восемь двенадцать");
        assertThat(ru.toText(new AtomicInteger(9001))).isEqualTo("девять тысяч одна");
        assertThat(ru.toText(new AtomicLong(9200))).isEqualTo("девять тысяч двести");
        assertThat(ru.toText(new DoubleAccumulator(Double::sum, 9020.0))).isEqualTo("девять тысяч двадцать ноль");
        assertThat(ru.toText(new DoubleAdder())).isEqualTo("ноль ноль");
    }
}
