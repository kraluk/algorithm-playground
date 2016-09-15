package com.kraluk.playground.algorithm.math;

import static com.kraluk.playground.algorithm.util.Integers.isInteger;
import static com.kraluk.playground.algorithm.util.Logarithms.log;

/**
 * Mathematical power of a given number
 *
 * @author lukasz
 */
public class Power {

    public static boolean logarithm(long number, long power) {
        double result = log(number, power);

        return isInteger(result);
    }
}