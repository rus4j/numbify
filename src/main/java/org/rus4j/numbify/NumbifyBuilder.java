package org.rus4j.numbify;

import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

public class NumbifyBuilder {
    private Language language;
    private boolean showIntegerCurrency = true;
    private boolean showDecimalCurrency = true;

    public NumbifyBuilder english() {
        this.language = new English(Currency.USD);
        return this;
    }

    public NumbifyBuilder english(Currency currency) {
        this.language = new English(currency);
        return this;
    }

    public NumbifyBuilder russian() {
        this.language = new Russian();
        return this;
    }

    public NumbifyBuilder russian(RuDeclension declension, Currency currency) {
        this.language = new Russian(declension, currency);
        return this;
    }

    public NumbifyBuilder hideIntCurrency() {
        this.showIntegerCurrency = false;
        return this;
    }

    public NumbifyBuilder hideDecimalCurrency() {
        this.showDecimalCurrency = false;
        return this;
    }

    public NumbifyBuilder customLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        return new Numbify(language, showIntegerCurrency, showDecimalCurrency);
    }

    // TODO add options (capitalization each, all, numbify only int, or only decimal part)
    // TODO negative numbers, minus sign
    // TODO text for decimal part
    // TODO custom Language
    // TODO Порядковые? Первый, Первая, Первое
}
