package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.lang.Currency;

import static org.assertj.core.api.Assertions.assertThat;

class CapitalizedTextTest {

    @Test
    public void capitalizeTest() {
        Numbify en = new NumbifyBuilder().english(Currency.USD).capitalize().build();
        assertThat(en.toText(123)).isEqualTo("One hundred twenty three dollars");
    }
}