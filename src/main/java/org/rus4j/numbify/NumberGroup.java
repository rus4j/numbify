package org.rus4j.numbify;

import java.math.BigDecimal;
import java.util.Arrays;

public class NumberGroup {
    private final Number number;

    public NumberGroup(Number number) {
        this.number = number;
    }

    public int[][] integerGroup() {
        return splitNumbersByGroups(toArray(number.longValue()));
    }

    public int[][] decimalGroup(boolean shouldBeRounded) {
        double value = number.doubleValue();
        String strNumber;
        if (shouldBeRounded) {
            strNumber = String.format("%.2f", value);
        } else {
            strNumber = BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
        }
        String strDecimal = strNumber.split("\\.")[1];
        long decimalPart = Long.parseLong(strDecimal);
        return splitNumbersByGroups(toArray(decimalPart));
    }

    public int decimalLength() {
        return BigDecimal.valueOf(number.doubleValue()).stripTrailingZeros().scale();
    }

    private int[] toArray(long number) {
        int[] digits = new int[String.valueOf(number).length()];
        int i = 0;
        while (number > 0) {
            digits[i++] = (int) (number % 10);
            number = number / 10;
        }
        return digits;
    }

    private int[][] splitNumbersByGroups(int[] numbers) {
        int[][] digitsByGroup = new int[(int) Math.ceil(numbers.length / 3.0)][3];
        int group = 0;
        for (int i = 0; i < numbers.length; i += 3) {
            digitsByGroup[group++] = Arrays.copyOfRange(numbers, i, i + 3);
        }
        return digitsByGroup;
    }

}
