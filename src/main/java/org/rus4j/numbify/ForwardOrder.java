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
            return tenText + compoundNumberDelimiter + unitText;
        }
        if (!tenText.isEmpty()) {
            return tenText;
        }
        return unitText;
    }
}
