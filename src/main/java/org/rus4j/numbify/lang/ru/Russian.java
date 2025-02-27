package org.rus4j.numbify.lang.ru;

import org.rus4j.numbify.Gender;
import org.rus4j.numbify.Language;

public class Russian implements Language {
    private final RuDictionary dict;
    private final RuDeclension declension;
    private final Gender gender;

    public Russian(RuDeclension declension, Gender gender) {
        this.dict = new RuDictionary();
        this.declension = declension;
        this.gender = gender;
    }

    public Russian() {
        this(RuDeclension.NOMINATIVE, Gender.MALE);
    }

    /**
     * If it is thousand group, then units should go in Female gender.
     * Example in russian: <pre>
     * 1000 = одн<b>a</b> тысяча
     * 42000 = сорок дв<b>е</b> тысячи</pre>
     */
    @Override
    public String unitNumber(int groupNum, int[] digits) {
        if (digits[0] == 0 && (digits[1] > 0 || digits[2] > 0)) {
            return "";
        }
        if (groupNum == 1) {
            return dict.units(Gender.FEMALE).get(declension)[digits[0]];
        } else if (groupNum == 0) {
            return dict.units(gender).get(declension)[digits[0]];
        }
        return dict.units(Gender.MALE).get(declension)[digits[0]];
    }

    @Override
    public String tenToNineteen(int i) {
        return dict.tenToNineteen.get(declension)[i];
    }

    @Override
    public String tens(int i) {
        return dict.tens.get(declension)[i];
    }

    @Override
    public String hundreds(int i) {
        return dict.hundreds.get(declension)[i];
    }

    @Override
    public String thousands(int form) {
        return dict.thousands.get(declension)[form];
    }

    @Override
    public String millions(int i) {
        return dict.millions[i];
    }

    @Override
    public String endings(int form) {
        return dict.endings.get(declension)[form];
    }

    /**
     * Russian language has 3 forms for thousands and millions.
     * Example in russian:<pre>
     * 1    тысяч<b>а</b>
     * 2-4  тысяч<b>и</b>
     * 5-20 тыся<b>ч</b></pre>
     */
    @Override
    public int form(int[] numGroup) {
        if (numGroup[1] == 1) {
            return 2;
        }
        return switch (numGroup[0]) {
            case 1 -> 0;
            case 2, 3, 4 -> 1;
            default -> 2;
        };
    }
}
