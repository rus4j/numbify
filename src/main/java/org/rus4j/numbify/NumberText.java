package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;
import org.rus4j.numbify.number.StringNumber;

public interface NumberText {
    String toText(StringNumber number, Language language);
}
