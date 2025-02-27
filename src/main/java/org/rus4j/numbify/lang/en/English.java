package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.Language;

public class English implements Language {

    @Override
    public String unitNumber(int groupNum, int[] digits) {
        if (digits[0] == 0 && (digits[1] > 0 || digits[2] > 0)) return "";
        return EnDictionary.units[digits[0]];
    }

    @Override
    public String tenToNineteen(int i) {
        return EnDictionary.tenToNineteen[i];
    }

    @Override
    public String tens(int i) {
        return EnDictionary.tens[i];
    }

    @Override
    public String hundreds(int i) {
        return EnDictionary.hundreds[i];
    }

    @Override
    public String thousands(int form) {
        return EnDictionary.thousand[form];
    }

    @Override
    public String millions(int i) {
        return EnDictionary.millions[i];
    }

    @Override
    public String endings(int form) {
        return EnDictionary.endings[form];
    }

    /**
     * There is only 1 form in English.
     * No difference between 1 thousand/million and 5 thousand/million.
     */
    @Override
    public int form(int[] numGroup) {
        return 0;
    }
}