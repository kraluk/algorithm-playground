package com.kraluk.playground.algorithm.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogarithmsTest {

    @Test
    public void logTest() {
        double result = Logarithms.log(9, 3);

        assertEquals(2.0, result, 0.0);
    }

    @Test
    public void log2Test() {
        double result = Logarithms.log2(8);

        assertEquals(3.0, result, 0.0);
    }
}