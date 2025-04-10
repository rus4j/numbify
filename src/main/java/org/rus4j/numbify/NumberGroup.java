package org.rus4j.numbify;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import org.rus4j.numbify.number.StringNumber;

public class NumberGroup {
    private final StringNumber number;
    private final AtomicReference<int[][]> intGroups = new AtomicReference<>();
    private final AtomicReference<int[][]> decimalGroups = new AtomicReference<>();

    public NumberGroup(StringNumber number) {
        this.number = number;
    }

    public int[][] integerGroup() {
        if (this.intGroups.get() == null) {
            String intPart = number.intString();
            this.intGroups.set(splitNumbersByGroups(toArray(intPart)));
        }
        return this.intGroups.get();
    }

    public int[][] decimalGroup() {
        if (this.decimalGroups.get() == null) {
            String decimalPart = number.decimalString();
            if (decimalPart.isEmpty()) return this.decimalGroups.updateAndGet(ints -> new int[][]{});
            this.decimalGroups.set(splitNumbersByGroups(toArray(decimalPart)));
        }
        return this.decimalGroups.get();
    }

    public int[] lastIntGroup() {
        int[][] ints = integerGroup();
        return ints[ints.length - 1];
    }

    public int[] lastDecimalGroup() {
        int[][] decimals = decimalGroup();
        if (decimals.length != 0) {
            return decimals[decimals.length - 1];
        }
        return new int[]{};
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
