package com.kraluk.playground.algorithm.util;

import lombok.experimental.UtilityClass;

/**
 * Logarithms Common Utils
 *
 * @author lukasz
 */
@UtilityClass
public final class Logarithms {

    public static double log(long number, long base) {
        return Math.log(number) / Math.log(base);
    }

    public static double log2(long number) {
        return log(number, 2);
    }
}
