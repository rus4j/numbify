package org.rus4j.numbify;

import java.util.StringJoiner;
import org.rus4j.numbify.lang.Language;

public class DigitByDigitText implements TextEngine {

    @Override
    public String toText(String number, Language lang, boolean isDecimal) {
        if (number.isEmpty()) {
            return "";
        }
        StringJoiner result = new StringJoiner(" ");
        for (char c : number.toCharArray()) {
            int digit = Character.getNumericValue(c);
            result.add(lang.unitNumber(0, new int[]{0, 0, digit}, isDecimal));
        }
        return result.toString();
    }
}