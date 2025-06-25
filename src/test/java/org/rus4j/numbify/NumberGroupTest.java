package org.rus4j.numbify;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGroupTest {

    @Test
    public void groupTest() {
        NumberGroup group = new NumberGroup("10");
        int[][] group1 = group.group();
        int[][] group2 = group.group();

        assertThat(group1).isEqualTo(new int[][]{new int[]{0, 1, 0}});
        assertThat(group1).isEqualTo(group2);
    }
}