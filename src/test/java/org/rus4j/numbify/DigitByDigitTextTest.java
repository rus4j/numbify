package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.Gender;
import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

import static org.assertj.core.api.Assertions.assertThat;

class DigitByDigitTextTest {

    @Test
    public void decimalOneByOneTest() {
        String point = new Numbify(
                new English(Currency.NUMBER, "point"),
                new CombinedText(
                        new IntText(new Text()),
                        new DecimalText(new DigitByDigitText())
                )
        ).toText(5.12);
        assertThat(point).isEqualTo("five point one two");
    }

    @Test
    public void integerOneByOneTest() {
        String point = new Numbify(
                new English(Currency.NUMBER, "point"),
                new CombinedText(
                        new IntText(new DigitByDigitText()),
                        new DecimalText(new Text())
                )
        ).toText(52.12);
        assertThat(point).isEqualTo("five two point twelve");
    }

    @Test
    public void bothOneByOneTest() {
        String point = new Numbify(
                new English(Currency.NUMBER, "point"),
                new CombinedText(
                        new IntText(new DigitByDigitText()),
                        new DecimalText(new DigitByDigitText())
                )
        ).toText(52.12);
        assertThat(point).isEqualTo("five two point one two");
    }

    @Test
    public void bothOneByOneRussianTest() {
        String point = new Numbify(
                new Russian(RuDeclension.NOMINATIVE, new Gender[]{Gender.MALE, Gender.MALE}, Currency.NUMBER, "и"),
                new CombinedText(
                        new IntText(new DigitByDigitText()),
                        new DecimalText(new DigitByDigitText())
                )
        ).toText(52.12);
        assertThat(point).isEqualTo("пять два и один два");
    }

    @Test
    public void zeroOneByOneTest() {
        String point = new Numbify(
                new English(Currency.NUMBER, "and"),
                new CombinedText(
                        new IntText(new DigitByDigitText()),
                        new DecimalText(new DigitByDigitText())
                )
        ).toText(1.001);
        assertThat(point).isEqualTo("one and zero zero one");
    }

    @Test
    public void emptyOneByOneTest() {
        String point = new Numbify(
                new English(Currency.NUMBER, "and"),
                new CombinedText(
                        new IntText(new Text()),
                        new DecimalText(new DigitByDigitText())
                )
        ).toText(1);
        assertThat(point).isEqualTo("one");
    }

    @Test
    public void oneByOneWithBuilderTest() {
        Numbify en = new NumbifyBuilder().english(Currency.NUMBER, "point")
                .hideDecimalCurrency()
                .digitByDigitDecimal()
                .build();
        assertThat(en.toText(1.42)).isEqualTo("one point four two");
    }
}