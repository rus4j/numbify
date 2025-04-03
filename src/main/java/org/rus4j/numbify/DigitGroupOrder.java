package org.rus4j.numbify;

/**
 * Different languages could have different digit ordering.
 * For example in English 23 is pronounced the same as it is written "twenty-three",
 * but in German it's pronounced backwards "drei und zwanzig" (3 and 20)
 */
public interface DigitGroupOrder {
    String text(String hundredText, String tenText, String unitText);
}
