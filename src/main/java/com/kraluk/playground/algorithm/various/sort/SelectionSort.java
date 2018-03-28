package com.kraluk.playground.algorithm.various.sort;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static com.kraluk.playground.algorithm.util.Maths.findMinIndex;
import static com.kraluk.playground.algorithm.util.Maths.swap;

/**
 * Selection Sort implementation
 *
 * @author lukasz
 */
@Log4j2
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