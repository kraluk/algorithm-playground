package com.kraluk.playground.algorithm.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegersTest {

    @Test
    public void isInteger() {
        boolean result = Integers.isInteger(2.00);

        assertEquals(true, result);
    }

    @Test
    public void isIntegerAlso() {
        boolean result = Integers.isInteger(2);

        assertEquals(true, result);
    }

    @Test
    public void isIntegerAlsoAlso() {
        boolean result = Integers.isInteger(2.00000000000000000);

        assertEquals(true, result);
    }

    @Test
    public void isNotInteger() {
        boolean result = Integers.isInteger(14.421);

        assertEquals(false, result);
    }
}