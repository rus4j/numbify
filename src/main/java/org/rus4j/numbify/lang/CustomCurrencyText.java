package org.rus4j.numbify.lang;

import org.rus4j.numbify.lang.en.EurCodeText;
import org.rus4j.numbify.lang.en.UsdCodeText;

/**
 * Implement this interface, if you want to use custom currency text in your output.
 * Say, instead of typically 'dollar'/'euros' you want it to be currency code as 'USD'/'EUR'.
 * There is a few default implementations:
 * {@link UsdCodeText}, {@link EurCodeText}
 */
public interface CustomCurrencyText {

    /**
     * @param digits group of last 3 digits the currency refer to.
     * @return text that going to be used as currency for integer part of the number. Not null.
     */
    String intCurrencyText(int[] digits);

    /**
     * @param digits group of last 3 digits the currency refer to.
     * @return text that going to be used as currency for decimal part of the number. Not null.
     */
    String decimalCurrencyText(int[] digits);
}
