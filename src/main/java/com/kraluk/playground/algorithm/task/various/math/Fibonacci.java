package com.kraluk.playground.algorithm.task.various.math;

/**
 * Fibonacci Sequence Calculations
 *
 * @author lukasz
 */
public class Fibonacci {

    public static long iterative(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long first = 0;
        long second = 1;

        for (long i = 2; i <= n; i++) {
            long calculation = first + second;
            first = second;
            second = calculation;
        }

        return second;
    }

    public static long recursive(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return recursive(n - 2) + recursive(n - 1);
    }
}