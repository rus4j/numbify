package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.lang.CustomCurrencyText;

public class EurCodeText implements CustomCurrencyText {
    @Override
    public String intCurrencyText(int[] digits) {
        return "EUR";
    }

    @Override
    public String decimalCurrencyText(int[] digits) {
        return digits[2] != 1 ? "cents" : "cent";
    }
}
