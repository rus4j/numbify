package org.rus4j.numbify;

public interface Language {
    String unitNumber(int groupNum, int[] digits);
    String tenToNineteen(int i);
    String tens(int i);
    String hundreds(int i);

    String endings(int form);
    String thousands(int form);
    String millions(int i);

    int form(int[] numGroup);
}
