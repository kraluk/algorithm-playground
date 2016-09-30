package com.kraluk.playground.algorithm.euler;

/**
 * Fibonacci even value summer
 *
 * @author lukasz
 */
public class FibonacciEvenSummer {

    public static long calculate(long maximum) {
        long result = 0;

        long a = 1;
        long b = 1;

        for (long temp = a + b; b < maximum; temp = a + b) {

            if (b % 2 == 0) {
                result += b;
            }

            a = b;
            b = temp;
        }

        return result;
    }

    public static long calculateWhiled(long maximum) {
        long result = 0;

        long a = 1;
        long b = 1;

        while (b < maximum) {

            if (b % 2 == 0) {
                result += b;
            }

            long temp = a + b;
            a = b;
            b = temp;
        }

        return result;
    }

    // Based on fact that every third Fibonacci number is even
    public static long calculateOptimized(long maximum) {
        long result = 0;

        long a = 1;
        long b = 1;
        long c = a + b;

        while (c < maximum) {
            result += c;

            a = b + c;
            b = c + a;
            c = a + b;
        }

        return result;
    }
}