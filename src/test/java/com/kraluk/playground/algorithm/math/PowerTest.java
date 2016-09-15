package com.kraluk.playground.algorithm.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerTest {

    @Test
    public void logarithmTest() {
        boolean result = Power.logarithm(9, 3);

        assertEquals(true, result);
    }

    @Test
    public void logarithmTwoTest() {
        boolean result = Power.logarithm(10, 3);

        assertEquals(false, result);
    }

    @Test
    public void logarithmThreeTest() {
        boolean result = Power.logarithm(10 * 4, 3);

        assertEquals(false, result);
    }

    @Test
    public void logarithmFourTest() {
        boolean result = Power.logarithm(4 * 4 * 4 * 4, 4);

        assertEquals(true, result);
    }
}