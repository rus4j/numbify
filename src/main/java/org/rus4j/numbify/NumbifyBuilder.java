package org.rus4j.numbify;

import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

public class NumbifyBuilder {
    private Language language;
    private boolean showIntegerCurrency = false;
    private boolean showDecimalCurrency = false;

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

    public NumbifyBuilder showIntegerCurrency(boolean show) {
        this.showIntegerCurrency = show;
        return this;
    }

    public NumbifyBuilder showDecimalCurrency(boolean show) {
        this.showDecimalCurrency = show;
        return this;
    }

    public NumbifyBuilder customLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        return new Numbify(language, showIntegerCurrency, showDecimalCurrency);
    }
}
