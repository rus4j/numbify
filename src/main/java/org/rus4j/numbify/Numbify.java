package org.rus4j.numbify;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbify {

    private final Declension declension;
    private final Gender gender;
    private final Language lang;

    public Numbify(Declension declension, Gender gender, Language language) {
        this.declension = declension;
        this.gender = gender;
        this.lang = language;
    }

    public String toText(Integer number) {
        int[] digits = toArray(number);
        int[][] byRank = splitRankChunks(digits);

        StringJoiner result = new StringJoiner(" ");
        for (int i = byRank.length - 1; i >= 0; i--) {
            if (byRank[i][0] == 0 && byRank[i][1] == 0 && byRank[i][2] == 0) continue;
            result.add(rankToText(byRank[i], i));
            int form = form(byRank[i]);
            if (i == 1) {
                result.add(lang.thousands().get(declension)[form]);
            } else if (i > 1) {
                result.add(lang.millions()[i - 2] + lang.endings().get(declension)[form]);
            }
        }
        return result.toString();
    }

    private int form(int[] numGroup) {
        if (numGroup[1] == 1) { // единица в десятках, 110-119 тысяч.
            return 2;
        }
        return switch (numGroup[0]) {
            case 1 -> 0; // 1 тысяча
            case 2, 3, 4 -> 1; // 2|3|4 тысячи
            default -> 2; // 5|6|7|8|9 тысяч
        };
    }

    private String rankToText(int[] digits, int groupNum) {
        String hundredText = lang.hundreds().get(declension)[digits[2]];
        String tenText;
        String unitText = "";
        if (digits[1] == 1) {
            tenText = lang.tenToNineteen().get(declension)[digits[0]];
        } else {
            tenText = lang.tens().get(declension)[digits[1]];
            unitText = unitNumber(groupNum, digits);
        }
        return Stream.of(hundredText, tenText, unitText)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }

    // Если это тысячи, то единицы должны быть в женском роде.
    // Example: 1 Миллион, но 1 тысяча.
    private String unitNumber(int groupNum, int[] digits) {
        if (digits[0] == 0 && (digits[1] > 0 || digits[2] > 0)) return "";
        if (groupNum == 1) {
            return lang.digits(Gender.FEMALE).get(declension)[digits[0]];
        } else if (groupNum == 0) {
            return lang.digits(gender).get(declension)[digits[0]];
        }
        return lang.digits(Gender.MALE).get(declension)[digits[0]];
    }

    // 1234 -> [4,3,2,1]
    private int[] toArray(int number) {
        int[] digits = new int[String.valueOf(number).length()];
        int i = 0;
        while (number > 0) {
            digits[i++] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    private int[][] splitRankChunks(int[] numbers) {
        int[][] digitsByGroup = new int[(int) Math.ceil(numbers.length / 3.0)][3];
        int group = 0;
        for (int i = 0; i < numbers.length; i += 3) {
            digitsByGroup[group++] = Arrays.copyOfRange(numbers, i, i + 3);
        }
        return digitsByGroup;
    }
}