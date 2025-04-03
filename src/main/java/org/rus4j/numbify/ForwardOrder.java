package org.rus4j.numbify;

public class ForwardOrder implements DigitGroupOrder {
    private final String compoundNumberDelimiter;

    public ForwardOrder(String compoundNumberDelimiter) {
        this.compoundNumberDelimiter = compoundNumberDelimiter;
    }

    @Override
    public String text(String hundredText, String tenText, String unitText) {
        if (!hundredText.isEmpty() && !tenText.isEmpty() && !unitText.isEmpty()) {
            return hundredText + " " + tenText + compoundNumberDelimiter + unitText;
        } else if (!hundredText.isEmpty() && !tenText.isEmpty()) {
            return hundredText + " " + tenText;
        } else if (!hundredText.isEmpty() && !unitText.isEmpty()) {
            return hundredText + " " + unitText;
        } else if (!hundredText.isEmpty()) {
            return hundredText;
        } else if (!tenText.isEmpty() && !unitText.isEmpty()) {
            return tenText + compoundNumberDelimiter + unitText;
        } else if (!tenText.isEmpty()) {
            return tenText;
        } else return unitText;
    }
}
