package com.kraluk.playground.algorithm.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MathsTest {

    @Test
    public void finMinIndexTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.finMinIndex(array, 0);

        assertEquals(1, index);
    }

    @Test
    public void finMinIndexSecondTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.finMinIndex(array, 2);

        assertEquals(3, index);
    }

    @Test
    public void finMinIndexThirdTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        int index = Maths.finMinIndex(array, 5);

        assertEquals(5, index);
    }

    @Test
    public void swapTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        Maths.swap(array, 5, 6);

        assertArrayEquals(new int[]{345, 0, 34, 1, 999, 555, 2}, array);
    }

    @Test
    public void swapSecondTest() {
        int[] array = {345, 0, 34, 1, 999, 2, 555};
        Maths.swap(array, 1, 5);

        assertArrayEquals(new int[]{345, 2, 34, 1, 999, 0, 555}, array);
    }
}