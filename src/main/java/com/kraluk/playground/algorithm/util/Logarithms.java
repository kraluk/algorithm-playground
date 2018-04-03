package com.kraluk.playground.algorithm.util;

/**
 * Logarithms Common Utils
 *
 * @author lukasz
 */
public final class Logarithms {

    public static double log(long number, long base) {
        return Math.log(number) / Math.log(base);
    }

    public static double log2(long number) {
        return log(number, 2);
    }
}
