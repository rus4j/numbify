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
    private boolean minusSign = false;
    private boolean digitByDigitDecimal = false;

    public NumbifyBuilder english() {
        return english(Currency.USD);
    }

    /**
     * Use english with specific currency and decimal separator.
     *
     * <pre>{@code
     * Numbify en = new NumbifyBuilder().english(Currency.NUMBER, "and").build();
     * en.toText(1.1); // "one and one tenths"
     *
     * // empty separator
     * Numbify en = new NumbifyBuilder().english(Currency.USD, "").build();
     * en.toText(1.1); // "one dollar one cent"
     * }</pre>
     *
     * @param currency currency
     * @param decimalSeparator separator between integer and decimal parts.
     * @return builder
     */
    public NumbifyBuilder english(Currency currency, String decimalSeparator) {
        this.language = new English(currency, decimalSeparator);
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

    public NumbifyBuilder originalInt() {
        this.originalInt = true;
        return this;
    }

    public NumbifyBuilder originalDecimal() {
        this.originalDecimal = true;
        return this;
    }

    public NumbifyBuilder negativeSign() {
        this.minusSign = true;
        return this;
    }

    public NumbifyBuilder digitByDigitDecimal() {
        this.digitByDigitDecimal = true;
        return this;
    }

    public NumbifyBuilder customLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        TextEngine textForInt = new Text();
        TextEngine textForDecimal = digitByDigitDecimal ? new DigitByDigitText() : textForInt;
        NumberText intText = originalInt ? new IntOriginalText() : new IntText(textForInt);
        NumberText decimalText = originalDecimal ? new DecimalOriginalText() : new DecimalText(textForDecimal);
        intText = showIntegerCurrency ? new IntCurrencyText(intText) : intText;
        decimalText = showDecimalCurrency ? new DecimalCurrencyText(decimalText) : decimalText;
        NumberText numberText = new CombinedText(intText, decimalText);
        numberText = minusSign ? new NegativeSignText(numberText) : numberText;
        numberText = capitalize ? new CapitalizedText(numberText) : numberText;
        return new Numbify(language, numberText);
    }
}
