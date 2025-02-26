package org.rus4j.numbify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Language<LANG_DECLENSION> {

    default Map<LANG_DECLENSION, String[]> digits(Gender gender) {
        return switch (gender) {
            case MALE -> maleDigits();
            case FEMALE -> femaleDigits();
            case NEUTRAL -> neutralDigits();
        };
    }

    Map<LANG_DECLENSION, String[]> maleDigits();
    Map<LANG_DECLENSION, String[]> femaleDigits();
    Map<LANG_DECLENSION, String[]> neutralDigits();
    Map<LANG_DECLENSION, String[]> tenToNineteen();
    Map<LANG_DECLENSION, String[]> tens();
    Map<LANG_DECLENSION, String[]> hundreds();

    Map<LANG_DECLENSION, String[]> thousands();
    String[] millions();
    Map<LANG_DECLENSION, String[]> endings();

    int form(int[] numGroup);

    default Map<LANG_DECLENSION, String[]> sameAsMaleBut(Map<LANG_DECLENSION, Map<Integer, String>> diff) {
        HashMap<LANG_DECLENSION, String[]> map = new HashMap<>(maleDigits());
        diff.forEach((key, value) -> map.computeIfPresent(key, (d, strings) -> replaceOnIndex(strings, value)));
        return map;
    }

    private static String[] replaceOnIndex(String[] arr, Map<Integer, String> map) {
        String[] newArr = Arrays.copyOf(arr, arr.length);
        map.forEach((key, value) -> newArr[key] = value);
        return newArr;
    }

}
