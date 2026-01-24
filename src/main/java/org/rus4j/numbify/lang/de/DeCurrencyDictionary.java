package org.rus4j.numbify.lang.de;

import org.rus4j.numbify.lang.Currency;

public class DeCurrencyDictionary {

    final String currency(Currency currency) {
        return switch (currency) {
            case RUB -> "Rubel";
            case USD -> "Dollar";
            case EUR -> "Euro";
            case NUMBER -> "";
        };
    }

    final String decimalCurrency(Currency currency,  int decimalLength) {
        return switch (currency) {
            case RUB -> "Kopeke";
            case USD, EUR -> "Cent";
            case NUMBER -> decimals[decimalLength];
        };
    }

    final String[] decimals = new String[]{
            "", "Zehntel", "Hundertstel",
            "Tausendstel", "Zehntausendstel", "Hunderttausendstel",
            "Millionstel", "Zehnmillionstel", "Hundertmillionstel",
            "Milliardstel", "Zehnmilliardstel", "Hundertmilliardstel",
            "Billionstel", "Zehnbillionstel", "Hundertbillionstel",
            "Billiardstel"
    };
}
