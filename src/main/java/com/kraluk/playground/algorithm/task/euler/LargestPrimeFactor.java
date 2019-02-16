package com.kraluk.playground.algorithm.task.euler;

import com.kraluk.playground.algorithm.common.Maths;

/**
 * Finds the largest prime factor of the given number
 *
 * @author lukasz
 */
public class LargestPrimeFactor {

    public static long calculate(long number) {
        long result = 0;
        long limit = number / 2;

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

    public static long calculateVeryCruded(long number) {
        long factor = 2;
        long lastFactor = 1;

        while (number > 1) {
            if (number % factor == 0) {
                lastFactor = factor;
                number = number / factor;

                while (number % factor == 0) {
                    number = number / factor;
                }
            }

            factor += 1;
        }

        return lastFactor;
    }

    public static long calculateImproved(long number) {
        long factor;
        long lastFactor;

        if (number % 2 == 0) {
            number /= 2;
            lastFactor = 2;

            while (number % 2 == 0) {
                number /= 2;
            }
        } else {
            lastFactor = 1;
        }

        factor = 3;

        while (number > 1) {
            if (number % factor == 0) {
                number /= factor;
                lastFactor = factor;

                while (number % factor == 0) {
                    number /= factor;
                }
            }

            factor += 2;
        }

        return lastFactor;
    }

    public static long calculateOptimized(long number) {
        long factor;
        long lastFactor;
        long maxFactor;

        if (number % 2 == 0) {
            lastFactor = 2;
            number /= 2;

            while (number % 2 == 0) {
                number /= 2;
            }
        } else {
            lastFactor = 1;
        }

        factor = 3;
        maxFactor = (long) Math.sqrt(number);

        while (number > 1 && factor <= maxFactor) {
            if (number % factor == 0) {
                number /= factor;
                lastFactor = factor;

                while (number % factor == 0) {
                    number /= factor;
                }

                maxFactor = (long) Math.sqrt(number);
            }

            factor += 2;
        }

        if (number == 1) {
            return lastFactor;
        } else {
            return number;
        }
    }
}