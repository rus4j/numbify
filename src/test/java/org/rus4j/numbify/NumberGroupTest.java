package org.rus4j.numbify;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGroupTest {

    @Test
    public void decimalGroupTest() {
        NumberGroup group = new NumberGroup(10.10);
        int[][] group1 = group.decimalGroup(true);
        int[][] group2 = group.decimalGroup(true);

        assertThat(group1).isEqualTo(new int[][]{new int[]{0, 1, 0}});
        assertThat(group1).isEqualTo(group2);
    }

    @Test
    public void lastDecimalGroupTest() {
        NumberGroup group = new NumberGroup(10);
        assertThat(group.lastDecimalGroup(false)).isEqualTo(new int[]{});

        group.decimalGroup(true);
        assertThat(group.lastDecimalGroup(false)).isEqualTo(new int[]{});

        NumberGroup numberGroup = new NumberGroup(10.1);
        numberGroup.decimalGroup(true);
        assertThat(numberGroup.lastDecimalGroup(false)).isEqualTo(new int[]{0, 1, 0});
    }
}