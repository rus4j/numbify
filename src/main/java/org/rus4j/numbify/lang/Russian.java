package org.rus4j.numbify.lang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.rus4j.numbify.lang.Declension.ACCUSATIVE;
import static org.rus4j.numbify.lang.Declension.DATIVE;
import static org.rus4j.numbify.lang.Declension.GENITIVE;
import static org.rus4j.numbify.lang.Declension.INSTRUMENTAL;
import static org.rus4j.numbify.lang.Declension.NOMINATIVE;
import static org.rus4j.numbify.lang.Declension.PREPOSITIONAL;

public class Russian {
    public static Map<Declension, String[]> MALE_DIGITS = Map.of(
            NOMINATIVE, new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            GENITIVE, new String[]{"ноля", "одного", "двух", "трёх", "четырёх", "пяти", "шести", "семи", "восьми", "девяти"},
            DATIVE, new String[]{"нолю", "одному", "двум", "трём", "четырём", "пяти", "шести", "семи", "восьми", "девяти"},
            ACCUSATIVE, new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            INSTRUMENTAL, new String[]{"нолём", "одним", "двумя", "тремя", "четырьмя", "пятью", "шестью", "семью", "восемью", "девятью"},
            PREPOSITIONAL, new String[]{"ноле", "одном", "двух", "трёх", "четырёх", "пяти", "шести", "семи", "восьми", "девяти"}
    );

    public static Map<Declension, String[]> FEMALE_DIGITS = sameAsMaleBut(Map.of(
            NOMINATIVE, Map.of(1, "одна", 2, "две"),
            GENITIVE, Map.of(1, "одной"),
            DATIVE, Map.of(1, "одной"),
            ACCUSATIVE, Map.of(1, "одну", 2, "две"),
            INSTRUMENTAL, Map.of(1, "одной"),
            PREPOSITIONAL, Map.of(1, "одной")
    ));

    public static Map<Declension, String[]> NEUTRAL_DIGITS = sameAsMaleBut(Map.of(
            NOMINATIVE, Map.of(1, "одно"), ACCUSATIVE, Map.of(1, "одно")
    ));

    public static Map<Declension, String[]> TEN_TO_NINETEEN = Map.of(
            NOMINATIVE, new String[]{"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                    "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
            GENITIVE, new String[]{"десяти", "одиннадцати", "двенадцати", "тринадцати", "четырнадцати",
                    "пятнадцати", "шестнадцати", "семнадцати", "восемнадцати", "девятнадцати"},
            DATIVE, new String[]{"десяти", "одиннадцати", "двенадцати", "тринадцати", "четырнадцати",
                    "пятнадцати", "шестнадцати", "семнадцати", "восемнадцати", "девятнадцати"},
            ACCUSATIVE, new String[]{"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                    "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
            INSTRUMENTAL, new String[]{"десятью", "одиннадцатью", "двенадцатью", "тринадцатью", "четырнадцатью",
                    "пятнадцатью", "шестнадцатью", "семнадцатью", "восемнадцатью", "девятнадцатью"},
            PREPOSITIONAL, new String[]{"десяти", "одиннадцати", "двенадцати", "тринадцати", "четырнадцати",
                    "пятнадцати", "шестнадцати", "семнадцати", "восемнадцати", "девятнадцати"}
    );

    public static Map<Declension, String[]> TENS = Map.of(
            NOMINATIVE, new String[]{"", "", "двадцать", "тридцать", "сорок", "пятьдесят",
                    "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
            GENITIVE, new String[]{"", "", "двадцати", "тридцати", "сорока", "пятидесяти",
                    "шестидесяти", "семидесяти", "восьмидесяти", "девяноста"},
            DATIVE, new String[]{"", "", "двадцати", "тридцати", "сорока", "пятидесяти",
                    "шестидесяти", "семидесяти", "восьмидесяти", "девяноста"},
            ACCUSATIVE, new String[]{"", "", "двадцать", "тридцать", "сорок", "пятьдесят",
                    "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
            INSTRUMENTAL, new String[]{"", "", "двадцатью", "тридцатью", "сорока", "пятьюдесятью",
                    "шестьюдесятью", "семьюдесятью", "восемьюдесятью", "девяноста"},
            PREPOSITIONAL, new String[]{"", "", "двадцати", "тридцати", "сорока", "пятидесяти",
                    "шестидесяти", "семидесяти", "восьмидесяти", "девяноста"}
    );

    public static Map<Declension, String[]> HUNDREDS = Map.of(
            NOMINATIVE, new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот",
                    "шестьсот", "семьсот", "восемьсот", "девятьсот"},
            GENITIVE, new String[]{"", "ста", "двухсот", "трёхсот", "четырёхсот", "пятисот",
                    "шестисот", "семисот", "восьмисот", "девятисот"},
            DATIVE, new String[]{"", "ста", "двумстам", "трёмстам", "четырёмстам", "пятистам",
                    "шестистам", "семистам", "восьмистам", "девятистам"},
            ACCUSATIVE, new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот",
                    "шестьсот", "семьсот", "восемьсот", "девятьсот"},
            INSTRUMENTAL, new String[]{"", "ста", "двумястами", "тремястами", "четырьмястами", "пятьюстами",
                    "шестьюстами", "семьюстами", "восемьюстами", "девятьюстами"},
            PREPOSITIONAL, new String[]{"", "ста", "двухстах", "трёхстах", "четырёхстах", "пятистах",
                    "шестистах", "семистах", "восьмистах", "девятистах"}
    );

    public static Map<Declension, String[]> THOUSANDS = Map.of(
            NOMINATIVE, new String[] {"тысяча", "тысячи", "тысяч"},
            GENITIVE, new String[] {"тысячи", "тысяч", "тысяч"},
            DATIVE, new String[] {"тысяче", "тысячам", "тысячам"},
            ACCUSATIVE, new String[] {"тысячу", "тысячи", "тысяч"},
            INSTRUMENTAL, new String[] {"тысячей", "тысячами", "тысячами"},
            PREPOSITIONAL, new String[] {"тысяче", "тысячах", "тысячах"}
    );

    public static String[] MILLIONS = new String[]{"миллион", "миллиард", "триллион", "квадриллион",
            "квинтиллион", "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион",
    };

    public static Map<Declension, String[]> ENDINGS = Map.of(
            NOMINATIVE, new String[] {"", "ы"},
            GENITIVE, new String[] {"а", "ов"},
            DATIVE, new String[] {"у", "ам"},
            ACCUSATIVE, new String[] {"", "а"},
            INSTRUMENTAL, new String[] {"ом", "ами"},
            PREPOSITIONAL, new String[] {"е", "ах"}
    );

    private static Map<Declension, String[]> sameAsMaleBut(Map<Declension, Map<Integer, String>> diff) {
        HashMap<Declension, String[]> map = new HashMap<>(MALE_DIGITS);
        diff.forEach((key, value) -> map.computeIfPresent(key, (d, strings) -> replaceOnIndex(strings, value)));
        return map;
    }

    private static String[] replaceOnIndex(String[] arr, Map<Integer, String> map) {
        String[] newArr = Arrays.copyOf(arr, arr.length);
        map.forEach((key, value) -> newArr[key] = value);
        return newArr;
    }
}
