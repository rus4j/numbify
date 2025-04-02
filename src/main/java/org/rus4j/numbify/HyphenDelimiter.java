package org.rus4j.numbify;

public class HyphenDelimiter implements CompoundNumberDelimiter {

    public String join(String hundredText, String tenText, String unitText) {
        if (!hundredText.isEmpty() && !tenText.isEmpty() && !unitText.isEmpty()) {
            return hundredText + " " + tenText + "-" + unitText;
        }
        if (!hundredText.isEmpty() && !tenText.isEmpty()) {
            return hundredText + " " + tenText;
        }
        if (!hundredText.isEmpty() && !unitText.isEmpty()) {
            return hundredText + " " + unitText;
        }
        if (!hundredText.isEmpty()) {
            return hundredText;
        }
        if (!tenText.isEmpty() && !unitText.isEmpty()) {
            return tenText + "-" + unitText;
        }
        if (!tenText.isEmpty()) {
            return tenText;
        }
        return unitText;
    }
}
