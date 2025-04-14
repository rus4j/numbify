package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.DigitGroupOrder;
import org.rus4j.numbify.ForwardOrder;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.Language;

public class English implements Language {
    private final EnDictionary dict;
    private final EnCurrencyDictionary currencyDict;
    private final Currency currency;
    private final String decimalSeparator;

    public English(Currency currency, String decimalSeparator) {
        this.currency = currency;
        this.dict = new EnDictionary();
        this.currencyDict = new EnCurrencyDictionary();
        this.decimalSeparator = decimalSeparator;
    }

    public English(Currency currency) {
        this(currency, "");
    }

    @Override
    public String unitNumber(int groupNum, int[] digits, boolean decimalPart) {
        if (digits[2] == 0 && (digits[0] > 0 || digits[1] > 0)) return "";
        return dict.units[digits[2]];
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
        boolean plural = numGroup[2] != 1;
        return currencyDict.currency(currency, plural);
    }

    @Override
    public String decimalCurrency(int[] numGroup, int decimalLength) {
        boolean plural = numGroup[2] != 1;
        return currencyDict.decimalCurrency(currency, plural, decimalLength);
    }

    /**
     * In english there is no additional endings for the word 'million'.
     */
    @Override
    public String endings(int[] numGroup) {
        return "";
    }

    @Override
    public boolean hasSpecificCurrency() {
        return !currency.equals(Currency.NUMBER);
    }

    @Override
    public String decimalSeparator() {
        return decimalSeparator;
    }

    @Override
    public DigitGroupOrder textOrder() {
        return new ForwardOrder("-");
    }

    @Override
    public String minusSign() {
        return "negative";
    }
}