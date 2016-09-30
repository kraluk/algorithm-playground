package com.kraluk.playground.algorithm.util;

/**
 * Common Mathematical operations
 *
 * @author lukasz
 */
public class Maths {

    public static int findMinIndex(int[] array, int from) {
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

    public static boolean isPrime(long number) {

        // Even test - note: 2 is even, but it's also a prime number!
        if (number > 2 && (number & 1) == 0) {
            return false;
        }

        // Only odd factors need to be tested up to number^(1/2)
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}