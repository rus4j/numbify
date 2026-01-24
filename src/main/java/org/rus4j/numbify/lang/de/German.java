package org.rus4j.numbify.lang.de;

import org.rus4j.numbify.BackwardOrder;
import org.rus4j.numbify.DigitGroupOrder;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.CustomCurrencyText;
import org.rus4j.numbify.lang.Gender;
import org.rus4j.numbify.lang.Language;

public class German implements Language {
    private final DeDictionary dict;
    private final DeCurrencyDictionary currencyDict;
    private final Gender[] genders;
    private final Currency currency;
    private final CustomCurrencyText customCurrencyText;
    private final String decimalSeparator;

    public German(
            Gender[] genders,
            Currency currency,
            CustomCurrencyText customCurrencyText,
            String decimalSeparator
    ) {
        this.dict = new DeDictionary();
        this.currencyDict = new DeCurrencyDictionary();
        this.genders = genders;
        this.currency = currency;
        this.customCurrencyText = customCurrencyText;
        this.decimalSeparator = decimalSeparator;
    }

    public German(Gender[] genders, Currency currency, String decimalSeparator) {
        this(genders, currency, null, decimalSeparator);
    }

    public German(Gender[] genders, CustomCurrencyText customCurrencyText, String decimalSeparator) {
        this(genders, null, customCurrencyText, decimalSeparator);
    }

    public German(Currency currency, String decimalSeparator) {
        this(currencyGender(currency), currency, decimalSeparator);
    }

    public German(Currency currency) {
        this(currency, decimalSeparator(currency));
    }

    private static Gender[] currencyGender(Currency currency) {
        return switch (currency) {
            case RUB -> new Gender[] {Gender.MALE, Gender.FEMALE};
            case USD, EUR, NUMBER -> new Gender[] {Gender.MALE, Gender.MALE};
        };
    }

    private static String decimalSeparator(Currency currency) {
        return currency == Currency.NUMBER ? "Komma" : "und";
    }

    /**
     * If the number ends with {@code x01}, the final digit {@code 1} is converted to {@code eins}.
     * Additionally, if the number belongs to a smaller group ({@code groupNum < 2}),
     * the conversion uses {@code currencyGender}; otherwise, the feminine form is applied.
     */
    @Override
    public String unitNumber(int groupNum, int[] digits, boolean decimalPart) {
        if (digits[2] == 0 && digits[0] > 0) return "";
        String ending = "";
        if (groupNum == 0 && digits[2] == 1 && currency == Currency.NUMBER) ending = "s";
        int currencyGender = decimalPart ? 1 : 0;
        if (groupNum < 2) {
            return dict.units(genders[currencyGender])[digits[2]] + ending;
        }
        return dict.units(Gender.FEMALE)[digits[2]] + ending;
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
    public String thousands(int[] digits) {
        return dict.thousand;
    }

    @Override
    public String largeNumbers(int i,  int[] digits) {
        return " " + dict.millions[i] + dict.endings[digits[2] > 1 ? 1 : 0] + " ";
    }

    @Override
    public String intCurrency(int[] digits) {
        if (customCurrencyText != null) {
            return customCurrencyText.intCurrencyText(digits);
        }
        return currencyDict.currency(currency);
    }

    @Override
    public String decimalCurrency(int[] digits, int decimalLength) {
        if (customCurrencyText != null) {
            return customCurrencyText.decimalCurrencyText(digits);
        }
        return currencyDict.decimalCurrency(currency, decimalLength);
    }

    @Override
    public boolean hasSpecificCurrency() {
        return currency != null && !currency.equals(Currency.NUMBER) || customCurrencyText != null;
    }

    @Override
    public String decimalSeparator() {
        return decimalSeparator;
    }

    @Override
    public DigitGroupOrder textOrder() {
        return new BackwardOrder("und");
    }

    @Override
    public String negativeSign() {
        return "minus";
    }
}
