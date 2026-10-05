package org.rus4j.numbify.lang.en;

import org.rus4j.numbify.lang.CustomCurrencyText;

public class UsdCodeText implements CustomCurrencyText {
    @Override
    public String intCurrencyText(int[] digits) {
        return "USD";
    }

    @Override
    public String decimalCurrencyText(int[] digits) {
        return digits[0] == 0 && digits[1] == 0 && digits[2] == 1 ? "cent" : "cents";
    }
}
