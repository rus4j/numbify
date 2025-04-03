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
    private String decimalSeparator = "";
    private DigitGroupOrder digitGroupOrder;

    public NumbifyBuilder english() {
        return english(Currency.USD);
    }

    public NumbifyBuilder english(Currency currency) {
        this.language = new English(currency);
        if (currency == Currency.NUMBER) {
            decimalSeparator = "and";
        }
        this.digitGroupOrder = new ForwardOrder("-");
        return this;
    }

    public NumbifyBuilder russian(Currency currency) {
        this.language = new Russian(currency);
        this.digitGroupOrder = new ForwardOrder(" ");
        return this;
    }

    public NumbifyBuilder russian(RuDeclension declension, Currency currency) {
        this.language = new Russian(declension, currency);
        this.digitGroupOrder = new ForwardOrder(" ");
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
        this.digitGroupOrder = new ForwardOrder(" ");
        return this;
    }

    public Numbify build() {
        Text text = new Text(language, digitGroupOrder);
        Numbify intText = originalInt ? new IntOriginalText(text) : new IntText(text);
        Numbify decimalText = originalDecimal ? new DecimalOriginalText(text) : new DecimalText(text);
        intText = showIntegerCurrency ? new IntCurrencyText(intText, text) : intText;
        decimalText = showDecimalCurrency ? new DecimalCurrencyText(decimalText, text) : decimalText;
        CombinedText combinedText = new CombinedText(intText, decimalText, decimalSeparator);
        return capitalize ? new CapitalizedText(combinedText) : combinedText;
    }
}
