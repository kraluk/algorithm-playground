package com.kraluk.playground.algorithm.math;

/**
 * Just Factorial calculations
 *
 * @author lukasz
 */
public class Factorial {

    public static long iterative(long number) {
        checkConditions(number);

        if (number <= 1) {
            return 1;
        }

        long result = 1;

        for (long i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    public static long recursive(long number) {
        checkConditions(number);

        if (number <= 1) {
            return 1;
        } else {
            return number * recursive(number - 1);
        }
    }

    private static void checkConditions(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Argument must be positive!");
        }
    }
}