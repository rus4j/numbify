package org.rus4j.numbify;

import org.rus4j.numbify.lang.Language;

public interface TextEngine {
    String toText(String number, Language lang, boolean isDecimal);
}