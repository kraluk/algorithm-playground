package com.kraluk.playground.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.kraluk.playground.algorithm.util.Maths.findMinIndex;
import static com.kraluk.playground.algorithm.util.Maths.swap;

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

            int min = findMinIndex(numArray, i);

            if (numArray[min] < numArray[i - 1]) {
                swap(numArray, i - 1, min);
            }
        }
    }
}