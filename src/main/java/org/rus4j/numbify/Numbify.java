package org.rus4j.numbify;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

import org.rus4j.numbify.lang.Declension;
import org.rus4j.numbify.lang.Gender;
import org.rus4j.numbify.lang.Russian;

import static org.rus4j.numbify.lang.Russian.ENDINGS;
import static org.rus4j.numbify.lang.Russian.FEMALE_DIGITS;
import static org.rus4j.numbify.lang.Russian.HUNDREDS;
import static org.rus4j.numbify.lang.Russian.MALE_DIGITS;
import static org.rus4j.numbify.lang.Russian.NEUTRAL_DIGITS;
import static org.rus4j.numbify.lang.Russian.TENS;
import static org.rus4j.numbify.lang.Russian.TEN_TO_NINETEEN;

public class Numbify {

    private final Declension declension;
    private final Gender gender;

    private final Map<Gender, Map<Declension, String[]>> GENDERS = Map.of(
            Gender.MALE, MALE_DIGITS, Gender.FEMALE, FEMALE_DIGITS, Gender.NEUTRAL, NEUTRAL_DIGITS
    );

    public Numbify(Declension declension, Gender gender) {
        this.declension = declension;
        this.gender = gender;
    }

    public String toText(Integer number) {
        int[] digits = toArray(number);
        int[][] byRank = splitRankChunks(digits);

        StringJoiner result = new StringJoiner(" ");
        for (int i = byRank.length - 1; i >= 0; i--) {
            result.add(rankToText(byRank[i]));
            if (i == 1) {
                int form = switch (byRank[i][0]) {
                    case 1 -> 0; // 1 тысяча
                    case 2, 3, 4 -> 1; // 2|3|4 тысячи
                    default -> 2; // 5|6|7|8|9 тысяч
                };
                result.add(Russian.THOUSANDS.get(declension)[form]);
            } else if (i > 1) {
                result.add(Russian.MILLIONS[i]).add(ENDINGS.get(declension)[0]);
            }
        }
        return result.toString();
    }

    private String rankToText(int[] digits) {
        String text = HUNDREDS.get(declension)[digits[2]];
        if (digits[1] == 1) {
            text += " " + TEN_TO_NINETEEN.get(declension)[digits[0]];
        } else if(digits[1] > 1) {
            text += " " + TENS.get(declension)[digits[1]];
            text += " " + GENDERS.get(gender).get(declension)[digits[0]];
        }
        return text;
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
            digitsByGroup[group++] = Arrays.copyOfRange(numbers, i, Math.min(numbers.length, i + 3));
        }
        return digitsByGroup;
    }

    public static void main(String[] args) {
        Numbify numbify = new Numbify(Declension.NOMINATIVE, Gender.NEUTRAL);
        System.out.println(numbify.toText(100321));
    }
}