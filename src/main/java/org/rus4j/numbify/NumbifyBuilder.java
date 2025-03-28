package org.rus4j.numbify;

import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

public class NumbifyBuilder {
    private Language language;
    private boolean showIntegerCurrency = true;
    private boolean showDecimalCurrency = true;
    private boolean capitalize = false;
    private boolean doNotConvertInt = false;
    private boolean doNotConvertDecimal = false;

    public NumbifyBuilder english() {
        this.language = new English(Currency.USD);
        return this;
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

    public NumbifyBuilder doNotConvertInt() {
        this.doNotConvertInt = true;
        return this;
    }

    public NumbifyBuilder doNotConvertDecimal() {
        this.doNotConvertDecimal = true;
        return this;
    }

    public NumbifyBuilder customLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        Text text = new Text();
        NumberText intText = doNotConvertInt ? new IntOriginalText() : text::intText;
        NumberText decimalText = doNotConvertDecimal ? new DecimalOriginalText() : text::decimalText;
        intText = showIntegerCurrency ? new IntCurrencyText(intText) : intText;
        decimalText = showDecimalCurrency ? new DecimalCurrencyText(decimalText) : decimalText;
        CombinedText combinedText = new CombinedText(language, intText, decimalText, new DelimiterText());
        return capitalize ? new CapitalizedText(combinedText) : combinedText;
    }
}
