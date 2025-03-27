package org.rus4j.numbify;

/**
 * Basic interface the user interact with.
 * Does the main thing - convert number to text.
 */
public interface Numbify {

    String toText(Number number);
}