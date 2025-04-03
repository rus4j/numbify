package org.rus4j.numbify;

public class ForwardOrder implements DigitGroupOrder {
    private final String compoundNumberDelimiter;

    public ForwardOrder(String compoundNumberDelimiter) {
        this.compoundNumberDelimiter = compoundNumberDelimiter;
    }

    @Override
    public String text(String hundredText, String tenText, String unitText) {
        byte emptyState = emptyState(hundredText, tenText, unitText);
        return switch (emptyState) {
            case 0b111 -> hundredText + " " + tenText + compoundNumberDelimiter + unitText;
            case 0b110 -> hundredText + " " + tenText;
            case 0b101 -> hundredText + " " + unitText;
            case 0b100 -> hundredText;
            case 0b011 -> tenText + compoundNumberDelimiter + unitText;
            case 0b010 -> tenText;
            default -> unitText;
        };
    }

    private static byte emptyState(String hundredText, String tenText, String unitText) {
        boolean[] isEmptyDigits = {unitText.isEmpty(), tenText.isEmpty(), hundredText.isEmpty()};
        byte emptyState = 0b000;
        for (int i = 0; i < isEmptyDigits.length; i++) {
            if (!isEmptyDigits[i]) {
                emptyState |= 1 << i;
            }
        }
        return emptyState;
    }
}
