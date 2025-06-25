package org.rus4j.numbify;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class NumberGroup {
    private final String number;
    private final AtomicReference<int[][]> groups = new AtomicReference<>();

    public NumberGroup(String number) {
        this.number = number;
    }

    public int[][] group() {
        if (this.groups.get() == null) {
            this.groups.set(splitNumbersByGroups(toArray(number)));
        }
        return this.groups.get();
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
