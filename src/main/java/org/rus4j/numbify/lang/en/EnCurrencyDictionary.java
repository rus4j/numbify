package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.lang.Currency;

public class EnCurrencyDictionary {

    final String currency(Currency currency, boolean pluralForm) {
        int form = pluralForm ? 1 : 0;
        return switch (currency) {
            case RUB -> ruble[form];
            case USD -> usd[form];
            case EUR -> euro[form];
            case NUMBER -> "";
        };
    }

    final String decimalCurrency(Currency currency, boolean pluralForm, int decimalLength) {
        int form = pluralForm ? 1 : 0;
        return switch (currency) {
            case RUB -> decimalRub[form];
            case USD, EUR -> cent[form];
            case NUMBER -> decimals[decimalLength];
        };
    }

    final String[] ruble = new String[]{"ruble", "rubles"};
    final String[] usd = new String[]{"dollar", "dollars"};
    final String[] euro = new String[]{"euro", "euros"};

    final String[] decimalRub = new String[]{"kopeck", "kopecks"};
    final String[] cent = new String[]{"cent", "cents"};

    final String[] decimals = new String[]{"", "tenths", "hundredths", "thousandths", "ten thousandths",
            "hundred thousandths", "millionth", "ten millionth", "hundred millionth", "billionth", "ten billionth",
            "hundred billionth", "trillionth", "ten trillionth", "hundred trillionth", "quadrillionth"};
}
