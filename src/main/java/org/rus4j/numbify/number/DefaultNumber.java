package org.rus4j.numbify.number;

import java.math.BigDecimal;

public class DefaultNumber implements StringNumber {
    private final Number number;
    private final boolean isNegative;

    public DefaultNumber(Number number) {
        this.number = number;
        this.isNegative = number.toString().charAt(0) == '-';
    }

    @Override
    public String intString() {
        return new BigDecimal(number.toString()).abs().toPlainString().split("\\.")[0];
    }

    @Override
    public String decimalString() {
        String[] split = new BigDecimal(number.toString()).toPlainString().split("\\.");
        if (split.length == 1) return "";
        String num = split[1];
        return removeTrailingZeros(num);
    }

    @Override
    public boolean isNegative() {
        return isNegative;
    }

    private String removeTrailingZeros(String num) {
        int n = num.length() - 1;
        int zeroCount = 0;
        for (int i = n; i >= 0; i--) {
            if (num.charAt(i) != '0') {
                break;
            }
            zeroCount++;
        }
        if (num.length() == zeroCount) return "0";
        return num.substring(0, num.length() - zeroCount);
    }
}