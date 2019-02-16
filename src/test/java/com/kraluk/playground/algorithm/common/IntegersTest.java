package com.kraluk.playground.algorithm.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegersTest {

    @Test
    @DisplayName("Check if given Double is an Integer value")
    void testIsIntegerWithDouble() {
        boolean result = Integers.isInteger(2.00);

        assertTrue(result);
    }

    @Test
    @DisplayName("Check if given Integer is an Integer value")
    void testIsIntegerWithRealInteger() {
        boolean result = Integers.isInteger(2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Check if given Double with several numbers after decimal point is an Integer value")
    void testIsIntegerWithBiggerDouble() {
        boolean result = Integers.isInteger(2.00000000000000000);

        assertTrue(result);
    }

    @Test
    @DisplayName("Check if given Double is not an Integer value")
    void testIsIntegerWithNonIntegerDouble() {
        boolean result = Integers.isInteger(14.421);

        assertFalse(result);
    }
}