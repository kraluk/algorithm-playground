package com.kraluk.playground.algorithm.util;

/**
 * Common Mathematical operations
 *
 * @author lukasz
 */
public class Maths {

    public static int finMinIndex(int[] array, int from) {
        int minIndex = from;

        for (int i = from + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}