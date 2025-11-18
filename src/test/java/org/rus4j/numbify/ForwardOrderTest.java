package org.rus4j.numbify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForwardOrderTest {

    @Test
    void forwardOrderTest() {
        ForwardOrder order = new ForwardOrder(" ");
        assertEquals("hundred twenty three", order.text("hundred", "twenty", "three", " "));
        assertEquals("hundred twenty", order.text("hundred", "twenty", "", " "));
        assertEquals("hundred three", order.text("hundred", "", "three", " "));

        assertEquals("hundred and twenty three", order.text("hundred", "twenty", "three", " and "));
        assertEquals("hundred and twenty", order.text("hundred", "twenty", "", " and "));
        assertEquals("hundred and three", order.text("hundred", "", "three", " and "));

        assertEquals("hundred", order.text("hundred", "", "", " "));
        assertEquals("twenty three", order.text("", "twenty", "three", " "));
        assertEquals("twenty", order.text("", "twenty", "", " "));
        assertEquals("three", order.text("", "", "three", " "));
        assertEquals("", order.text("", "", "", " "));
    }

    @Test
    void forwardOrderWithCompoundNumberDelimiter() {
        ForwardOrder order = new ForwardOrder(" and ");
        assertEquals("hundred twenty and three", order.text("hundred", "twenty", "three", " "));
        assertEquals("hundred twenty", order.text("hundred", "twenty", "", " "));
        assertEquals("hundred three", order.text("hundred", "", "three", " "));

        assertEquals("hundred and twenty and three", order.text("hundred", "twenty", "three", " and "));
        assertEquals("hundred and twenty", order.text("hundred", "twenty", "", " and "));
        assertEquals("hundred and three", order.text("hundred", "", "three", " and "));

        assertEquals("hundred", order.text("hundred", "", "", " "));
        assertEquals("twenty and three", order.text("", "twenty", "three", " "));
        assertEquals("twenty", order.text("", "twenty", "", " "));
        assertEquals("three", order.text("", "", "three", " "));
        assertEquals("", order.text("", "", "", " "));
    }
}