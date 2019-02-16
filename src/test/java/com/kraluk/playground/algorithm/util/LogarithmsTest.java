package com.kraluk.playground.algorithm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogarithmsTest {

    @Test
    void logTest() {
        double result = Logarithms.log(9, 3);

        assertEquals(2.0, result, 0.0);
    }

    @Test
    void log2Test() {
        double result = Logarithms.log2(8);

        assertEquals(3.0, result, 0.0);
    }
}