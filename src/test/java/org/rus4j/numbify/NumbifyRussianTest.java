package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

import static org.assertj.core.api.Assertions.assertThat;

class NumbifyRussianTest {

    @Test
    public void testNominativeMale() {
        Numbify ru = new NumbifyBuilder().language(new Russian()).build();
        assertThat(ru.toText(0)).isEqualTo("ноль");
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

    @Test
    public void testNominativeFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.NOMINATIVE)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одна");
        assertThat(ru.toText(2)).isEqualTo("две");
        assertThat(ru.toText(101)).isEqualTo("сто одна");
        assertThat(ru.toText(102)).isEqualTo("сто две");
        assertThat(ru.toText(1_001)).isEqualTo("одна тысяча одна");
        assertThat(ru.toText(1_000_001)).isEqualTo("один миллион одна");
        assertThat(ru.toText(1_000_002)).isEqualTo("один миллион две");
    }

    @Test
    public void testNominativeNeutral() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.NOMINATIVE)
                .gender(Gender.NEUTRAL)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одно");
        assertThat(ru.toText(101)).isEqualTo("сто одно");
        assertThat(ru.toText(1_001)).isEqualTo("одна тысяча одно");
        assertThat(ru.toText(1_000_001)).isEqualTo("один миллион одно");
    }

    @Test
    public void testGenitiveMale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.GENITIVE)
                .gender(Gender.MALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(0)).isEqualTo("ноля");
        assertThat(ru.toText(1)).isEqualTo("одного");
        assertThat(ru.toText(12)).isEqualTo("двенадцати");
        assertThat(ru.toText(123)).isEqualTo("ста двадцати трёх");
        assertThat(ru.toText(1_234)).isEqualTo("одной тысячи двухсот тридцати четырёх");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцати тысяч трёхсот сорока пяти");
        assertThat(ru.toText(123_456)).isEqualTo("ста двадцати трёх тысяч четырёхсот пятидесяти шести");
        assertThat(ru.toText(1_234_567)).isEqualTo("одного миллиона двухсот тридцати четырёх тысяч пятисот шестидесяти семи");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцати миллионов трёхсот сорока пяти тысяч шестисот семидесяти восьми");
        assertThat(ru.toText(123_456_789)).isEqualTo("ста двадцати трёх миллионов четырёхсот пятидесяти шести тысяч семисот восьмидесяти девяти");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("одного миллиарда двухсот тридцати четырёх миллионов пятисот шестидесяти семи тысяч восьмисот девяноста");

        assertThat(ru.toText(100)).isEqualTo("ста");
        assertThat(ru.toText(101)).isEqualTo("ста одного");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысячи одного");
        assertThat(ru.toText(100_000)).isEqualTo("ста тысяч");
        assertThat(ru.toText(1_000_001)).isEqualTo("одного миллиона одного");
    }

    @Test
    public void testGenitiveFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.GENITIVE)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одной");
        assertThat(ru.toText(101)).isEqualTo("ста одной");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысячи одной");
        assertThat(ru.toText(1_000_001)).isEqualTo("одного миллиона одной");
    }

    @Test
    public void testAccusativeMale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.ACCUSATIVE)
                .gender(Gender.MALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(0)).isEqualTo("ноль");
        assertThat(ru.toText(1)).isEqualTo("один");
        assertThat(ru.toText(12)).isEqualTo("двенадцать");
        assertThat(ru.toText(123)).isEqualTo("сто двадцать три");
        assertThat(ru.toText(1_234)).isEqualTo("одну тысячу двести тридцать четыре");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцать тысяч триста сорок пять");
        assertThat(ru.toText(123_456)).isEqualTo("сто двадцать три тысячи четыреста пятьдесят шесть");
        assertThat(ru.toText(1_234_567)).isEqualTo("один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцать миллионов триста сорок пять тысяч шестьсот семьдесят восемь");
        assertThat(ru.toText(123_456_789)).isEqualTo("сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("один миллиард двести тридцать четыре миллиона пятьсот шестьдесят семь тысяч восемьсот девяносто");

        assertThat(ru.toText(100)).isEqualTo("сто");
        assertThat(ru.toText(101)).isEqualTo("сто один");
        assertThat(ru.toText(1_001)).isEqualTo("одну тысячу один");
        assertThat(ru.toText(100_000)).isEqualTo("сто тысяч");
        assertThat(ru.toText(1_000_001)).isEqualTo("один миллион один");
    }

    @Test
    public void testAccusativeFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.ACCUSATIVE)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одну");
        assertThat(ru.toText(101)).isEqualTo("сто одну");
        assertThat(ru.toText(1_001)).isEqualTo("одну тысячу одну");
        assertThat(ru.toText(1_000_001)).isEqualTo("один миллион одну");
    }

    @Test
    public void testDativeMale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.DATIVE)
                .gender(Gender.MALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(0)).isEqualTo("нолю");
        assertThat(ru.toText(1)).isEqualTo("одному");
        assertThat(ru.toText(12)).isEqualTo("двенадцати");
        assertThat(ru.toText(123)).isEqualTo("ста двадцати трём");
        assertThat(ru.toText(1_234)).isEqualTo("одной тысяче двумстам тридцати четырём");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцати тысячам трёмстам сорока пяти");
        assertThat(ru.toText(123_456)).isEqualTo("ста двадцати трём тысячам четырёмстам пятидесяти шести");
        assertThat(ru.toText(1_234_567)).isEqualTo("одному миллиону двумстам тридцати четырём тысячам пятистам шестидесяти семи");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцати миллионам трёмстам сорока пяти тысячам шестистам семидесяти восьми");
        assertThat(ru.toText(123_456_789)).isEqualTo("ста двадцати трём миллионам четырёмстам пятидесяти шести тысячам семистам восьмидесяти девяти");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("одному миллиарду двумстам тридцати четырём миллионам пятистам шестидесяти семи тысячам восьмистам девяноста");

        assertThat(ru.toText(100)).isEqualTo("ста");
        assertThat(ru.toText(101)).isEqualTo("ста одному");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысяче одному");
        assertThat(ru.toText(100_000)).isEqualTo("ста тысячам");
        assertThat(ru.toText(1_000_001)).isEqualTo("одному миллиону одному");
    }

    @Test
    public void testDativeFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.DATIVE)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одной");
        assertThat(ru.toText(101)).isEqualTo("ста одной");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысяче одной");
        assertThat(ru.toText(1_000_001)).isEqualTo("одному миллиону одной");
    }

    @Test
    public void testInstrumentalMale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.INSTRUMENTAL)
                .gender(Gender.MALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(0)).isEqualTo("нолём");
        assertThat(ru.toText(1)).isEqualTo("одним");
        assertThat(ru.toText(12)).isEqualTo("двенадцатью");
        assertThat(ru.toText(123)).isEqualTo("ста двадцатью тремя");
        assertThat(ru.toText(1_234)).isEqualTo("одной тысячей двумястами тридцатью четырьмя");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцатью тысячами тремястами сорока пятью");
        assertThat(ru.toText(123_456)).isEqualTo("ста двадцатью тремя тысячами четырьмястами пятьюдесятью шестью");
        assertThat(ru.toText(1_234_567)).isEqualTo("одним миллионом двумястами тридцатью четырьмя тысячами пятьюстами шестьюдесятью семью");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцатью миллионами тремястами сорока пятью тысячами шестьюстами семьюдесятью восемью");
        assertThat(ru.toText(123_456_789)).isEqualTo("ста двадцатью тремя миллионами четырьмястами пятьюдесятью шестью тысячами семьюстами восемьюдесятью девятью");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("одним миллиардом двумястами тридцатью четырьмя миллионами пятьюстами шестьюдесятью семью тысячами восемьюстами девяноста");

        assertThat(ru.toText(100)).isEqualTo("ста");
        assertThat(ru.toText(101)).isEqualTo("ста одним");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысячей одним");
        assertThat(ru.toText(100_000)).isEqualTo("ста тысячами");
        assertThat(ru.toText(1_000_001)).isEqualTo("одним миллионом одним");
    }

    @Test
    public void testInstrumentalFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.INSTRUMENTAL)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одной");
        assertThat(ru.toText(101)).isEqualTo("ста одной");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысячей одной");
        assertThat(ru.toText(1_000_001)).isEqualTo("одним миллионом одной");
    }

    @Test
    public void testPrepositionalMale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.PREPOSITIONAL)
                .gender(Gender.MALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(0)).isEqualTo("ноле");
        assertThat(ru.toText(1)).isEqualTo("одном");
        assertThat(ru.toText(12)).isEqualTo("двенадцати");
        assertThat(ru.toText(123)).isEqualTo("ста двадцати трёх");
        assertThat(ru.toText(1_234)).isEqualTo("одной тысяче двухстах тридцати четырёх");
        assertThat(ru.toText(12_345)).isEqualTo("двенадцати тысячах трёхстах сорока пяти");
        assertThat(ru.toText(123_456)).isEqualTo("ста двадцати трёх тысячах четырёхстах пятидесяти шести");
        assertThat(ru.toText(1_234_567)).isEqualTo("одном миллионе двухстах тридцати четырёх тысячах пятистах шестидесяти семи");
        assertThat(ru.toText(12_345_678)).isEqualTo("двенадцати миллионах трёхстах сорока пяти тысячах шестистах семидесяти восьми");
        assertThat(ru.toText(123_456_789)).isEqualTo("ста двадцати трёх миллионах четырёхстах пятидесяти шести тысячах семистах восьмидесяти девяти");
        assertThat(ru.toText(1_234_567_890)).isEqualTo("одном миллиарде двухстах тридцати четырёх миллионах пятистах шестидесяти семи тысячах восьмистах девяноста");

        assertThat(ru.toText(100)).isEqualTo("ста");
        assertThat(ru.toText(101)).isEqualTo("ста одном");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысяче одном");
        assertThat(ru.toText(100_000)).isEqualTo("ста тысячах");
        assertThat(ru.toText(1_000_001)).isEqualTo("одном миллионе одном");
    }

    @Test
    public void testPrepositionalFemale() {
        Numbify ru = new NumbifyBuilder()
                .declension(RuDeclension.PREPOSITIONAL)
                .gender(Gender.FEMALE)
                .language(new Russian())
                .build();
        assertThat(ru.toText(1)).isEqualTo("одной");
        assertThat(ru.toText(101)).isEqualTo("ста одной");
        assertThat(ru.toText(1_001)).isEqualTo("одной тысяче одной");
        assertThat(ru.toText(1_000_001)).isEqualTo("одном миллионе одной");
    }

}