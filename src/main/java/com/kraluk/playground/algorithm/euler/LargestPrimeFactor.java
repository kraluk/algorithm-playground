package com.kraluk.playground.algorithm.euler;

import com.kraluk.playground.algorithm.util.Maths;

/**
 * Finds the largest prime factor of the given number
 *
 * @author lukasz
 */
public class LargestPrimeFactor {

    public static long calculate(long number) {
        long result = 0;
        long limit = (long) Math.sqrt(number);

        for (long i = 1; i <= limit; i += 1) {
            if (number % i == 0) {
                if (i > result && Maths.isPrime(i)) {
                    result = i;
                }
            }
        }

        if (result == 1) {
            return -1;
        } else {
            return result;
        }
    }

    public static long calculateOptimized(long number) {
        long result = 0;

        // TODO: implement this method!

        return result;
    }
}