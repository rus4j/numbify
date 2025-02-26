package org.rus4j.numbify.lang.en;

import java.util.Map;

import org.rus4j.numbify.Language;

import static org.rus4j.numbify.lang.en.EnDeclension.COMMON;

public class English implements Language<EnDeclension> {

    private static final Map<EnDeclension, String[]> DIGITS = Map.of(
            COMMON, new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}
    );

    @Override
    public Map<EnDeclension, String[]> maleDigits() {
        return DIGITS;
    }

    @Override
    public Map<EnDeclension, String[]> femaleDigits() {
        return DIGITS;
    }

    @Override
    public Map<EnDeclension, String[]> neutralDigits() {
        return DIGITS;
    }

    @Override
    public Map<EnDeclension, String[]> tenToNineteen() {
        return Map.of(
                COMMON, new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen",
                        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
                }
        );
    }

    @Override
    public Map<EnDeclension, String[]> tens() {
        return Map.of(
                COMMON, new String[]{"", "", "twenty", "thirty", "forty",
                        "fifty", "sixty", "seventy", "eighty", "ninety"
                }
        );
    }

    @Override
    public Map<EnDeclension, String[]> hundreds() {
        return Map.of(
                COMMON, new String[]{"", "one hundred", "two hundred", "three hundred", "four hundred",
                        "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"
                }
        );
    }

    @Override
    public Map<EnDeclension, String[]> thousands() {
        return Map.of(COMMON, new String[]{"thousand"});
    }

    @Override
    public String[] millions() {
        return new String[]{"million", "billion", "trillion", "quadrillion",
                "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion",
        };
    }

    @Override
    public Map<EnDeclension, String[]> endings() {
        return Map.of(COMMON, new String[]{""});
    }

    /**
     * There is only 1 from in English.
     * No difference between 1 thousand/million and 5 thousand/million.
     */
    @Override
    public int form(int[] numGroup) {
        return 0;
    }
}
