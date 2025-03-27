package org.rus4j.numbify;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class NumberGroup {
    private final Number number;
    private final AtomicReference<int[][]> intGroups = new AtomicReference<>();
    private final AtomicReference<int[][]> decimalGroups = new AtomicReference<>();

    public NumberGroup(Number number) {
        this.number = number;
    }

    public int[][] integerGroup() {
        if (this.intGroups.get() == null) {
            String intPart = new BigDecimal(number.toString()).toPlainString().split("\\.")[0];
            this.intGroups.set(splitNumbersByGroups(toArray(intPart)));
        }
        return this.intGroups.get();
    }

    public int[][] decimalGroup(boolean shouldBeRounded) {
        if (this.decimalGroups.get() == null) {
            String[] split = new BigDecimal(number.toString()).toPlainString().split("\\.");
            if (split.length == 1) return new int[][]{};
            String num = split[1];
            String normalize = shouldBeRounded ? round(num) : removeTrailingZeros(num);
            this.decimalGroups.set(splitNumbersByGroups(toArray(normalize)));
        }
        return this.decimalGroups.get();
    }

    public int decimalLength() {
        return BigDecimal.valueOf(number.doubleValue()).stripTrailingZeros().scale();
    }

    public int[] lastIntGroup() {
        int[][] ints = integerGroup();
        return ints[ints.length - 1];
    }

    public int[] lastDecimalGroup() {
        int[][] decimals = decimalGroups.get();
        if (decimals != null && decimals.length != 0) {
            return decimals[decimals.length - 1];
        }
        return new int[]{};
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

    private String round(String num) {
        if (num.length() < 2) {
            return num + "0".repeat(2 - num.length());
        }
        return num.substring(0, 2);
    }

    private int[] toArray(String number) {
        char[] chars = number.toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = chars[i] - 48;
        }
        return arr;
    }

    private int[][] splitNumbersByGroups(int[] numbers) {
        int zeroToAdd = zeroToAdd(numbers);
        int[][] digitsByGroup = new int[(int) Math.ceil(numbers.length / 3.0)][3];

        int[] numberArray = new int[numbers.length + zeroToAdd];
        System.arraycopy(numbers, 0, numberArray, zeroToAdd, numbers.length);

        int group = 0;
        for (int i = 0; i < numberArray.length; i += 3) {
            digitsByGroup[group++] = Arrays.copyOfRange(numberArray, i, i + 3);
        }
        return digitsByGroup;
    }

    private int zeroToAdd(int[] number) {
        int modulo = number.length % 3;
        return modulo == 0 ? 0 : 3 - modulo;
    }
}
