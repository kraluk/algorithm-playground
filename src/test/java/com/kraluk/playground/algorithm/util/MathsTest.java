package com.kraluk.playground.algorithm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathsTest {

    @Test
    void finMinIndexTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.findMinIndex(array, 0);

        assertEquals(1, index);
    }

    @Test
    void finMinIndexSecondTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.findMinIndex(array, 2);

        assertEquals(3, index);
    }

    @Test
    void finMinIndexThirdTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.findMinIndex(array, 5);

        assertEquals(5, index);
    }

    @Test
    void swapTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        Maths.swap(array, 5, 6);

        assertArrayEquals(new int[]{345, 0, 34, 1, 999, 555, 2}, array);
    }

    @Test
    void swapSecondTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        Maths.swap(array, 1, 5);

        assertArrayEquals(new int[]{345, 2, 34, 1, 999, 0, 555}, array);
    }

    @Test
    void isPrimeTest() {
        boolean result = Maths.isPrime(29);

        assertTrue(result);
    }

    @Test
    void isPrimeSecondTest() {
        boolean result = Maths.isPrime(81);

        assertFalse(result);
    }
}