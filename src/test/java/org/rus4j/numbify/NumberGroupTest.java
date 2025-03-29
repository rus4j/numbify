package org.rus4j.numbify;

import org.junit.jupiter.api.Test;
import org.rus4j.numbify.number.DefaultNumber;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGroupTest {

    @Test
    public void decimalGroupTest() {
        NumberGroup group = new NumberGroup(new DefaultNumber(10.10));
        int[][] group1 = group.decimalGroup();
        int[][] group2 = group.decimalGroup();

        assertThat(group1).isEqualTo(new int[][]{new int[]{0, 0, 1}});
        assertThat(group1).isEqualTo(group2);
    }

    @Test
    public void lastDecimalGroupTest() {
        NumberGroup group = new NumberGroup(new DefaultNumber(10));
        assertThat(group.lastDecimalGroup()).isEqualTo(new int[]{});

        group.decimalGroup();
        assertThat(group.lastDecimalGroup()).isEqualTo(new int[]{});

        NumberGroup numberGroup = new NumberGroup(new DefaultNumber(10.1));
        numberGroup.decimalGroup();
        assertThat(numberGroup.lastDecimalGroup()).isEqualTo(new int[]{0, 0, 1});
    }
}