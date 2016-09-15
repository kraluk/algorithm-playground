package com.kraluk.playground.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Selection Sort implementation
 *
 * @author lukasz
 */
@Slf4j
public class SelectionSort {

    public static void sort(int[] numArray) {
        int n = numArray.length;

        for (int i = 1; i < n; i++) {
            log.info(Arrays.toString(numArray));

            int min = finMinIndex(numArray, i);

            if (numArray[min] < numArray[i - 1]) {
                swap(numArray, i - 1, min);
            }
        }
    }

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
