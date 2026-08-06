package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public class IntOriginalText implements NumberText {

    @Override
    public String toText(StringNumber number, Language language) {
        String text = number.intString();

        return number.isNegative() ? "- " + text : text;
    }
}
