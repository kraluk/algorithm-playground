package com.kraluk.playground.algorithm.util;

import lombok.experimental.UtilityClass;

/**
 * Integers Common Utils
 *
 * @author lukasz
 */
@UtilityClass
public final class Integers {

    public static boolean isInteger(double number) {
        return (number % 1) == 0;
    }
}