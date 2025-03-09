package org.rus4j.numbify;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbify {

    private final Language lang;

    public Numbify(Language lang) {
        this.lang = lang;
    }

    public String toText(Integer number) {
        return toText(number.longValue());
    }

    public String toText(Long number) {
        int[] digits = toArray(number);
        int[][] groups = splitNumbersByGroups(digits);

        StringJoiner result = new StringJoiner(" ");
        for (int i = groups.length - 1; i >= 0; i--) {
            if (groups[i][0] == 0 && groups[i][1] == 0 && groups[i][2] == 0 && groups.length > 1) continue;
            result.add(groupToText(groups[i], i));
            if (i == 1) {
                result.add(lang.thousands(groups[i]));
            } else if (i > 1) {
                result.add(lang.largeNumbers(i - 2) + lang.endings(groups[i]));
            }
        }
        return result.add(lang.intCurrency(groups[0])).toString().trim();
    }

    private String groupToText(int[] digits, int groupNum) {
        String hundredText = lang.hundreds(digits[2]);
        String tenText;
        String unitText = "";
        if (digits[1] == 1) {
            tenText = lang.tenToNineteen(digits[0]);
        } else {
            tenText = lang.tens(digits[1]);
            unitText = lang.unitNumber(groupNum, digits);
        }
        return Stream.of(hundredText, tenText, unitText)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
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