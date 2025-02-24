package org.rus4j.numbify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Language {

    default Map<Declension, String[]> digits(Gender gender) {
        return switch (gender) {
            case MALE -> maleDigits();
            case FEMALE -> femaleDigits();
            case NEUTRAL -> neutralDigits();
        };
    }

    Map<Declension, String[]> maleDigits();
    Map<Declension, String[]> femaleDigits();
    Map<Declension, String[]> neutralDigits();
    Map<Declension, String[]> tenToNineteen();
    Map<Declension, String[]> tens();
    Map<Declension, String[]> hundreds();

    Map<Declension, String[]> thousands();
    String[] millions();
    Map<Declension, String[]> endings();

    default Map<Declension, String[]> sameAsMaleBut(Map<Declension, Map<Integer, String>> diff) {
        HashMap<Declension, String[]> map = new HashMap<>(maleDigits());
        diff.forEach((key, value) -> map.computeIfPresent(key, (d, strings) -> replaceOnIndex(strings, value)));
        return map;
    }

    private static String[] replaceOnIndex(String[] arr, Map<Integer, String> map) {
        String[] newArr = Arrays.copyOf(arr, arr.length);
        map.forEach((key, value) -> newArr[key] = value);
        return newArr;
    }

}
