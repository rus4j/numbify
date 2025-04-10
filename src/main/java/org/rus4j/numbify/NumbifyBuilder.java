package org.rus4j.numbify;

import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

public class NumbifyBuilder {
    private Language language;
    private boolean showIntegerCurrency = true;
    private boolean showDecimalCurrency = true;
    private boolean capitalize = false;
    private boolean originalInt = false;
    private boolean originalDecimal = false;

    public NumbifyBuilder english() {
        return english(Currency.USD);
    }

    public NumbifyBuilder english(Currency currency) {
        this.language = new English(currency);
        return this;
    }

    public NumbifyBuilder russian(Currency currency) {
        this.language = new Russian(currency);
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

    public NumbifyBuilder capitalize() {
        this.capitalize = true;
        return this;
    }

    public NumbifyBuilder originalInt() {
        this.originalInt = true;
        return this;
    }

    public NumbifyBuilder originalDecimal() {
        this.originalDecimal = true;
        return this;
    }

    public NumbifyBuilder customLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        Text text = new Text();
        NumberText intText = originalInt ? new IntOriginalText() : new IntText(text);
        NumberText decimalText = originalDecimal ? new DecimalOriginalText() : new DecimalText(text);
        intText = showIntegerCurrency ? new IntCurrencyText(intText) : intText;
        decimalText = showDecimalCurrency ? new DecimalCurrencyText(decimalText) : decimalText;
        CombinedText combinedText = new CombinedText(intText, decimalText);
        NumberText c = capitalize ? new CapitalizedText(combinedText) : combinedText;
        return new Numbify(language, c);
    }
}
