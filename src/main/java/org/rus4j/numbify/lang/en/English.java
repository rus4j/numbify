package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.Currency;
import org.rus4j.numbify.Language;

public class English implements Language {
    private final EnDictionary dict;
    private final EnCurrencyDictionary currencyDict;
    private final Currency currency;

    public English(Currency currency) {
        this.currency = currency;
        this.dict = new EnDictionary();
        this.currencyDict = new EnCurrencyDictionary();
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
    public String thousands(int[] numGroup) {
        return dict.thousand;
    }

    @Override
    public String largeNumbers(int i) {
        return dict.millions[i];
    }

    @Override
    public String intCurrency(int[] numGroup) {
        boolean plural = numGroup[0] > 1 || numGroup[1] > 0 || numGroup[2] > 0;
        return currencyDict.currency(currency, plural);
    }

    @Override
    public String decimalCurrency(int[] numGroup) {
        boolean plural = numGroup[0] > 1 || numGroup[1] > 0 || numGroup[2] > 0;
        return currencyDict.decimalCurrency(currency, plural);
    }

    /**
     * In english there is no additional endings for the word 'million'.
     */
    @Override
    public String endings(int[] numGroup) {
        return "";
    }
}