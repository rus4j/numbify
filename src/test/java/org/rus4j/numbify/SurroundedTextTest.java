package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;
import org.rus4j.numbify.lang.en.English;

import static org.assertj.core.api.Assertions.assertThat;

public class SurroundedTextTest {
    @Test
    public void surroundedTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new SurroundedText(
                        new IntText(new Text()),
                        "(",
                        ")"
                )
        );

        assertThat(en.toText(123)).isEqualTo("(one hundred twenty-three)");
    }

    @Test
    public void nestedSurroundedTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new SurroundedText(
                        new CombinedText(
                                new IntText(new Text()),
                                new SurroundedText(
                                        new DecimalText(new Text()),
                                        "[",
                                        "]"
                                )
                        ),
                        "{",
                        "}"
                )
        );

        assertThat(en.toText(123.45)).isEqualTo("{one hundred twenty-three [forty-five]}");
    }

    @Test
    public void surroundedCurrencyTextTest() {
        Numbify en = new Numbify(
                new English(Currency.USD),
                new IntCurrencyText(
                        new SurroundedText(
                                new IntText(new Text()),
                                "(",
                                ")"
                        )
                )
        );

        assertThat(en.toText(123)).isEqualTo("(one hundred twenty-three) dollars");
    }

    @Test
    public void surroundedNegativeTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new SurroundedText(
                                new NegativeSignText(
                                        new IntText(new Text())
                                ),
                                "(",
                                ")"
                )
        );

        assertThat(en.toText(-123)).isEqualTo("(negative one hundred twenty-three)");
    }

    @Test
    public void surroundedEmptyTextTest() {
        Numbify en = new Numbify(
                new English(Currency.NUMBER),
                new SurroundedText(
                        new DecimalText(new Text()),
                        "(",
                        ")"
                )
        );

        assertThat(en.toText(123)).isEmpty();
    }

    @Test
    public void surroundedTextWithABuilderTest() {
        Numbify en = new NumbifyBuilder()
                .english(Currency.NUMBER)
                .hideIntCurrency()
                .hideDecimalCurrency()
                .surround("{", "}")
                .build();

        assertThat(en.toText(123.45)).isEqualTo("{one hundred twenty-three forty-five}");
    }
}
