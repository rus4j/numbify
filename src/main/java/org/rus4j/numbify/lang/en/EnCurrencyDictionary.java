package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.Currency;

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

    final String decimalCurrency(Currency currency, boolean pluralForm) {
        int form = pluralForm ? 1 : 0;
        return switch (currency) {
            case RUB -> decimalRub[form];
            case USD, EUR -> cent[form];
            case NUMBER -> "";
        };
    }

    final String[] ruble = new String[]{"ruble", "rubles"};
    final String[] usd = new String[]{"dollar", "dollars"};
    final String[] euro = new String[]{"euro", "euros"};

    final String[] decimalRub = new String[]{"kopeck", "kopecks"};
    final String[] cent = new String[]{"cent", "cents"};
}
