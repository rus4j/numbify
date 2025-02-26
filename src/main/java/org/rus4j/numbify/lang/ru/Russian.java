package org.rus4j.numbify.lang.ru;

import java.util.Map;

import org.rus4j.numbify.Language;

import static org.rus4j.numbify.lang.ru.RuDeclension.ACCUSATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.DATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.GENITIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.INSTRUMENTAL;
import static org.rus4j.numbify.lang.ru.RuDeclension.NOMINATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.PREPOSITIONAL;

public class Russian implements Language<RuDeclension> {
    @Override
    public Map<RuDeclension, String[]> maleDigits() {
        return Map.of(
                NOMINATIVE, new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                GENITIVE, new String[]{"ноля", "одного", "двух", "трёх", "четырёх", "пяти", "шести", "семи", "восьми", "девяти"},
                DATIVE, new String[]{"нолю", "одному", "двум", "трём", "четырём", "пяти", "шести", "семи", "восьми", "девяти"},
                ACCUSATIVE, new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                INSTRUMENTAL, new String[]{"нолём", "одним", "двумя", "тремя", "четырьмя", "пятью", "шестью", "семью", "восемью", "девятью"},
                PREPOSITIONAL, new String[]{"ноле", "одном", "двух", "трёх", "четырёх", "пяти", "шести", "семи", "восьми", "девяти"}
        );
    }

    @Override
    public Map<RuDeclension, String[]> femaleDigits() {
        return sameAsMaleBut(Map.of(
                NOMINATIVE, Map.of(1, "одна", 2, "две"),
                GENITIVE, Map.of(1, "одной"),
                DATIVE, Map.of(1, "одной"),
                ACCUSATIVE, Map.of(1, "одну", 2, "две"),
                INSTRUMENTAL, Map.of(1, "одной"),
                PREPOSITIONAL, Map.of(1, "одной")
        ));
    }

    @Override
    public Map<RuDeclension, String[]> neutralDigits() {
        return sameAsMaleBut(Map.of(
                NOMINATIVE, Map.of(1, "одно"), ACCUSATIVE, Map.of(1, "одно")
        ));
    }

    @Override
    public Map<RuDeclension, String[]> tenToNineteen() {
        return Map.of(
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
    }

    @Override
    public Map<RuDeclension, String[]> tens() {
        return Map.of(
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
    }

    @Override
    public Map<RuDeclension, String[]> hundreds() {
        return Map.of(
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
    }

    @Override
    public Map<RuDeclension, String[]> thousands() {
        return Map.of(
                NOMINATIVE, new String[] {"тысяча", "тысячи", "тысяч"},
                GENITIVE, new String[] {"тысячи", "тысяч", "тысяч"},
                DATIVE, new String[] {"тысяче", "тысячам", "тысячам"},
                ACCUSATIVE, new String[] {"тысячу", "тысячи", "тысяч"},
                INSTRUMENTAL, new String[] {"тысячей", "тысячами", "тысячами"},
                PREPOSITIONAL, new String[] {"тысяче", "тысячах", "тысячах"}
        );
    }

    @Override
    public String[] millions() {
        return new String[]{"миллион", "миллиард", "триллион", "квадриллион",
                "квинтиллион", "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион",
        };
    }

    @Override
    public Map<RuDeclension, String[]> endings() {
        return Map.of(
                NOMINATIVE, new String[] {"", "а", "ов"},
                GENITIVE, new String[] {"а", "ов", "ов"},
                DATIVE, new String[] {"у", "ам", "ам"},
                ACCUSATIVE, new String[] {"", "а", "ов"},
                INSTRUMENTAL, new String[] {"ом", "ами", "ами"},
                PREPOSITIONAL, new String[] {"е", "ах", "ах"}
        );
    }

    @Override
    public int form(int[] numGroup) {
        if (numGroup[1] == 1) { // единица в десятках, 110-119 тысяч.
            return 2;
        }
        return switch (numGroup[0]) {
            case 1 -> 0; // 1 тысяча
            case 2, 3, 4 -> 1; // 2|3|4 тысячи
            default -> 2; // 5|6|7|8|9 тысяч
        };
    }
}
