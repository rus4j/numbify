package org.rus4j.numbify.lang.ru;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.CombinedText;
import org.rus4j.numbify.DecimalCurrencyText;
import org.rus4j.numbify.DecimalOriginalText;
import org.rus4j.numbify.IntCurrencyText;
import org.rus4j.numbify.IntText;
import org.rus4j.numbify.Numbify;
import org.rus4j.numbify.Text;
import org.rus4j.numbify.lang.CustomCurrencyText;
import org.rus4j.numbify.lang.Gender;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RussianCustomCurrencyTest {
    @Test
    public void testCustomCurrencyText() {
        Russian russian = new Russian(
                RuDeclension.NOMINATIVE, new Gender[]{Gender.MALE, Gender.FEMALE}, new CustomDollarText(), "и"
        );

        Numbify numbify = new Numbify(
                russian,
                new CombinedText(
                        new IntCurrencyText(new IntText(new Text())),
                        new DecimalCurrencyText(new DecimalOriginalText())
                )
        );

        assertThat(numbify.toText(10.0)).isEqualTo("десять долларов США и 00 центов");
    }

    static class CustomDollarText implements CustomCurrencyText {
        @Override
        public String intCurrencyText(int[] numGroup) {
            if (numGroup[1] == 1) {
                return "долларов США";
            }
            return switch (numGroup[2]) {
                case 1 -> "доллар США";
                case 2, 3, 4 -> "доллара США";
                default -> "долларов США";
            };
        }

        @Override
        public String decimalCurrencyText(int[] numGroup) {
            if (numGroup[1] == 1) {
                return "центов";
            }
            return switch (numGroup[2]) {
                case 1 -> "цент";
                case 2, 3, 4 -> "цента";
                default -> "центов";
            };
        }
    }
}
