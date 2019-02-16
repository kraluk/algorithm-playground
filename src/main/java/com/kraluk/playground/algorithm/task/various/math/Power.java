package com.kraluk.playground.algorithm.task.various.math;

import static com.kraluk.playground.algorithm.common.Integers.isInteger;
import static com.kraluk.playground.algorithm.common.Logarithms.log;

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