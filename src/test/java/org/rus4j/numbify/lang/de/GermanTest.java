package org.rus4j.numbify.lang.de;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.SolidText;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class GermanTest {
    @Test
    public void nominativeTest() {
        Numbify de = new Numbify(
                new German(Currency.NUMBER),
                new IntCurrencyText(new IntText(new SolidText()))
        );
        assertThat(de.toText(0)).isEqualTo("null");
        assertThat(de.toText(1)).isEqualTo("eins");
        assertThat(de.toText(12)).isEqualTo("zwölf");
        assertThat(de.toText(123)).isEqualTo("einhundertdreiundzwanzig");
        assertThat(de.toText(1_234)).isEqualTo("eintausendzweihundertvierunddreißig");
        assertThat(de.toText(12_345)).isEqualTo("zwölftausenddreihundertfünfundvierzig");
        assertThat(de.toText(123_456)).isEqualTo("einhundertdreiundzwanzigtausendvierhundertsechsundfünfzig");
        assertThat(de.toText(1_234_567)).isEqualTo("eine Million zweihundertvierunddreißigtausendfünfhundertsiebenundsechzig");
        assertThat(de.toText(12_345_678)).isEqualTo("zwölf Millionen dreihundertfünfundvierzigtausendsechshundertachtundsiebzig");
        assertThat(de.toText(123_456_789)).isEqualTo("einhundertdreiundzwanzig Millionen vierhundertsechsundfünfzigtausendsiebenhundertneunundachtzig");
        assertThat(de.toText(1_234_567_890)).isEqualTo("eine Milliarde zweihundertvierunddreißig Millionen fünfhundertsiebenundsechzigtausendachthundertneunzig");

        assertThat(de.toText(100)).isEqualTo("einhundert");
        assertThat(de.toText(101)).isEqualTo("einhunderteins");
        assertThat(de.toText(1_001)).isEqualTo("eintausendeins");

        assertThat(de.toText(1_100)).isEqualTo("eintausendeinhundert");
        assertThat(de.toText(1_010)).isEqualTo("eintausendzehn");
        assertThat(de.toText(1_110)).isEqualTo("eintausendeinhundertzehn");
        assertThat(de.toText(1_000)).isEqualTo("eintausend");
        assertThat(de.toText(100_000)).isEqualTo("einhunderttausend");
        assertThat(de.toText(1_000_001)).isEqualTo("eine Million eins");
    }

    @Test
    public void cornerCasesTest() {
        Numbify de = new Numbify(
                new German(Currency.NUMBER),
                new IntCurrencyText(new IntText(new SolidText()))
        );

        assertThat(de.toText(1_024)).isEqualTo("eintausendvierundzwanzig");
        assertThat(de.toText(101)).isEqualTo("einhunderteins");
    }
}
