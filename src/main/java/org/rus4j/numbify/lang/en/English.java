package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.Language;

public class English implements Language {
    private final EnDictionary dict;

    public English() {
        this.dict = new EnDictionary();
    }

    @Override
    public String unitNumber(int groupNum, int[] digits) {
        if (digits[0] == 0 && (digits[1] > 0 || digits[2] > 0)) return "";
        return dict.units[digits[0]];
    }

    @Override
    public String tenToNineteen(int i) {
        return dict.tenToNineteen[i];
    }

    @Override
    public String tens(int i) {
        return dict.tens[i];
    }

    @Override
    public String hundreds(int i) {
        return dict.hundreds[i];
    }

    @Override
    public String thousands(int form) {
        return dict.thousand[form];
    }

    @Override
    public String millions(int i) {
        return dict.millions[i];
    }

    @Override
    public String endings(int form) {
        return dict.endings[form];
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