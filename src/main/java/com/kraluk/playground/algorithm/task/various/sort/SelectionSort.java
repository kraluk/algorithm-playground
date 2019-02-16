package com.kraluk.playground.algorithm.task.various.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static com.kraluk.playground.algorithm.common.Maths.findMinIndex;
import static com.kraluk.playground.algorithm.common.Maths.swap;

/**
 * Selection Sort implementation
 *
 * @author lukasz
 */
public class SelectionSort {
    private static final Logger log = LogManager.getLogger(SelectionSort.class);

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