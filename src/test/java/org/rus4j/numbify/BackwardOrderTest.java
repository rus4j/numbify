package org.rus4j.numbify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackwardOrderTest {

    @Test
    void backwardOrder() {
        BackwardOrder order = new BackwardOrder(" ");
        assertEquals("hundred three twenty", order.text("hundred", "twenty", "three", " "));
        assertEquals("hundred twenty", order.text("hundred", "twenty", "", " "));
        assertEquals("hundred three", order.text("hundred", "", "three", " "));

        assertEquals("hundred and three twenty", order.text("hundred", "twenty", "three", " and "));
        assertEquals("hundred and twenty", order.text("hundred", "twenty", "", " and "));
        assertEquals("hundred and three", order.text("hundred", "", "three", " and "));

        assertEquals("hundred", order.text("hundred", "", "", " "));
        assertEquals("three twenty", order.text("", "twenty", "three", " "));
        assertEquals("twenty", order.text("", "twenty", "", " "));
        assertEquals("three", order.text("", "", "three", " "));
        assertEquals("", order.text("", "", "", " "));
    }

    @Test
    void backwardOrderWithCompoundNumberDelimiter() {
        BackwardOrder order = new BackwardOrder(" and ");
        assertEquals("hundred three and twenty", order.text("hundred", "twenty", "three", " "));
        assertEquals("hundred twenty", order.text("hundred", "twenty", "", " "));
        assertEquals("hundred three", order.text("hundred", "", "three", " "));

        assertEquals("hundred and three and twenty", order.text("hundred", "twenty", "three", " and "));
        assertEquals("hundred and twenty", order.text("hundred", "twenty", "", " and "));
        assertEquals("hundred and three", order.text("hundred", "", "three", " and "));

        assertEquals("hundred", order.text("hundred", "", "", " "));
        assertEquals("three and twenty", order.text("", "twenty", "three", " "));
        assertEquals("twenty", order.text("", "twenty", "", " "));
        assertEquals("three", order.text("", "", "three", " "));
        assertEquals("", order.text("", "", "", " "));
        assertEquals("", order.text("", "", "", ""));
    }
}