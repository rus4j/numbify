package org.rus4j.numbify.lang.ru;

import org.rus4j.numbify.DigitGroupOrder;
import org.rus4j.numbify.ForwardOrder;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.Gender;
import org.rus4j.numbify.lang.Language;

public class Russian implements Language {
    private final RuDictionary dict;
    private final RuCurrencyDictionary currencyDict;
    private final RuDeclension declension;
    private final Gender[] genders;
    private final Currency currency;
    private final String decimalSeparator;

    public Russian(RuDeclension declension, Gender[] genders, Currency currency, String decimalSeparator) {
        this.dict = new RuDictionary();
        this.currencyDict = new RuCurrencyDictionary();
        this.declension = declension;
        this.genders = genders;
        this.currency = currency;
        this.decimalSeparator = decimalSeparator;
    }

    public Russian(RuDeclension declension, Currency currency) {
        this(declension, currencyGender(currency), currency, "");
    }

    public Russian(Currency currency) {
        this(RuDeclension.NOMINATIVE, currency);
    }

    /**
     * Returns Gender array where gender[0] - is gender for integer part of the currency
     * and gender[1] - is gender for decimal part of the currency
     */
    private static Gender[] currencyGender(Currency currency) {
        return switch (currency) {
            case RUB -> new Gender[] {Gender.MALE, Gender.FEMALE};
            case USD, EUR -> new Gender[] {Gender.MALE, Gender.MALE};
            case NUMBER -> new Gender[] {Gender.FEMALE, Gender.FEMALE};
        };
    }

    /**
     * If it is a thousand group, then units should go in Female gender.
     * Example in russian: <pre>
     * 1000 = одн<b>a</b> тысяча
     * 42000 = сорок дв<b>е</b> тысячи</pre>
     */
    @Override
    public String unitNumber(int groupNum, int[] digits, boolean decimalPart) {
        if (digits[2] == 0 && (digits[0] > 0 || digits[1] > 0)) {
            return "";
        }
        int currencyGender = decimalPart ? 1 : 0;
        if (groupNum == 1) {
            return dict.units(Gender.FEMALE).get(declension)[digits[2]];
        } else if (groupNum == 0) {
            return dict.units(genders[currencyGender]).get(declension)[digits[2]];
        }
        return dict.units(Gender.MALE).get(declension)[digits[2]];
    }

    @Override
    public String tenToNineteen(int i) {
        return dict.tenToNineteen.get(declension)[i];
    }

    @Override
    public String tens(int i) {
        return dict.tens.get(declension)[i];
    }

    @Override
    public String hundreds(int i) {
        return dict.hundreds.get(declension)[i];
    }

    @Override
    public String thousands(int[] numGroup) {
        return dict.thousands.get(declension)[form(numGroup)];
    }

    @Override
    public String largeNumbers(int i) {
        return dict.millions[i];
    }

    @Override
    public String intCurrency(int[] numGroup) {
        return currencyDict.currency(currency, declension, form(numGroup));
    }

    @Override
    public String decimalCurrency(int[] digits, int decimalLength) {
        return currencyDict.decimalCurrency(currency, declension, decimalLength, form(digits));
    }

    @Override
    public boolean hasSpecificCurrency() {
        return !currency.equals(Currency.NUMBER);
    }

    /**
     * In russian there are 3 forms on endings for the word 'million'.
     * See {@link Russian#form(int[])}
     */
    @Override
    public String endings(int[] numGroup) {
        return dict.endings.get(declension)[form(numGroup)];
    }

    @Override
    public String decimalSeparator() {
        return decimalSeparator;
    }

    @Override
    public DigitGroupOrder textOrder() {
        return new ForwardOrder(" ");
    }

    @Override
    public String minusSign() {
        return "минус";
    }

    /**
     * Russian language has 3 forms for thousands and millions.
     * Example in russian:<pre>
     * 1    тысяч<b>а</b>
     * 2-4  тысяч<b>и</b>
     * 5-20 тыся<b>ч</b></pre>
     */
    public int form(int[] numGroup) {
        if (numGroup[1] == 1) {
            return 2;
        }
        return switch (numGroup[2]) {
            case 1 -> 0;
            case 2, 3, 4 -> 1;
            default -> 2;
        };
    }
}
