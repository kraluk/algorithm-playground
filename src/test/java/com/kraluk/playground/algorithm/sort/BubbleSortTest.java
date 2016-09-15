package com.kraluk.playground.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void sortTest() {
        int[] array = {345, 2, 34, 1, 999, 0, 555};
        BubbleSort.sort(array);

        Assert.assertArrayEquals(new int[] {0, 1, 2, 34, 345, 555, 999}, array);
    }

    @Test
    public void sortInverseTest() {
        int[] array = {345, 2, 34, 1, 999, 0, 555};
        BubbleSort.sortInverse(array);

        Assert.assertArrayEquals(new int[] {0, 1, 2, 34, 345, 555, 999}, array);
    }
}
