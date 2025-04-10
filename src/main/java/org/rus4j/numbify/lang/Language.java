package org.rus4j.numbify.lang;

import org.rus4j.numbify.DigitGroupOrder;

/**
 * Every language must implement this interface.
 * Used in {@link org.rus4j.numbify.CombinedText} to transform number to text depends on specific language.
 */
public interface Language {

    /**
     * Transforms unit to text based on group the unit belongs to and other digits in the group.
     * @param groupNum number of group. 0 for units, 1 for a thousand, 2 for a million, 3 for a billion, etc.
     * @param digits group of digits in current group. Arrays of length 3. The number 123 is represented as [1,2,3].
     * @return text representation of digits[2] number.
     */
    String unitNumber(int groupNum, int[] digits, boolean decimalPart);

    /**
     * Transforms number from 10 to 19 to text.
     * @param i last digit of number. From 0 to 9.
     * @return text representation of number.
     */
    String tenToNineteen(int i);

    /**
     * Transforms tens to text.
     * @param i number of tens. From 2 to 9. To transform number with one ten see {@link #tenToNineteen(int)}
     * @return text representation of tens.
     */
    String tens(int i);

    /**
     * Transform hundreds to text.
     * @param i number of hundreds. From 1 to 9.
     * @return text representation of hundreds.
     */
    String hundreds(int i);

    /**
     * Languages could have different endings for the word 'million'
     * depending on number they refer to.
     * @param digits group of last 3 digits the words refer to.
     * @return ending.
     */
    String endings(int[] digits);

    /**
     * Languages could have different forms of the word 'thousand'
     * depending on number they refer to.
     * @param digits group of last 3 digits the word refer to.
     * @return right form of the word 'thousand'.
     */
    String thousands(int[] digits);

    /**
     * Transforms -<b>illion</b> number to text.
     * @param i order of number. 0 for a million, 1 for a billion, 2 for a trillion, etc.
     * @return text representation of large -illion number.
     */
    String largeNumbers(int i);

    /**
     * Transforms integer part of currency to text.
     * @param digits group of last 3 digits the currency refer to.
     * @return currency text for integer part of the number.
     */
    String intCurrency(int[] digits);

    /**
     * Transforms decimal part of currency to text.
     * @param digits group of last 3 digits the currency refer to.
     * @param decimalLength length of decimal part
     * @return currency text for decimal part of the number.
     */
    String decimalCurrency(int[] digits, int decimalLength);

    /**
     * @return true if language has currency different from {@link Currency#NUMBER}.
     */
    boolean hasSpecificCurrency();

    /**
     * @return separator between integer and decimal parts
     */
    String decimalSeparator();

    /**
     * @return digit group order the language uses to write numbers in text
     */
    DigitGroupOrder textOrder();
}
