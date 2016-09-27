package com.kraluk.playground.algorithm.various.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Bubble Sort implementation
 *
 * @author lukasz
 */
@Slf4j
public class BubbleSort {

    public static void sort(int[] numArray) {

        int n = numArray.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {

            log.info(Arrays.toString(numArray));

            for (int j = 1; j < (n - i); j++) {

                if (numArray[j - 1] > numArray[j]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
    }

    public static void sortInverse(int[] numArray) {

        int n = numArray.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {

            log.info(Arrays.toString(numArray));

            for (int j = n - 1; j > i; j--) {

                if (numArray[j - 1] > numArray[j]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
    }
}