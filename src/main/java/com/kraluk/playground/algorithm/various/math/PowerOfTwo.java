package com.kraluk.playground.algorithm.various.math;

import static com.kraluk.playground.algorithm.util.Integers.isInteger;
import static com.kraluk.playground.algorithm.util.Logarithms.log2;

/**
 * Mathematical power of 2
 *
 * @author lukasz
 */
public class PowerOfTwo {

    public static boolean bruteForce(long number) {

        long powerTwo = 2;

        while (true) {
            if (number == powerTwo) {
                return true;
            }

            powerTwo *= 2;

            if (powerTwo > number) {
                return false;
            }
        }
    }

    public static boolean logarithm(long number) {

        double result = log2(number);

        return isInteger(result);
    }

    public static boolean bitwise(long number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    public static boolean bitwiseOtherApproach(long number) {
        return number > 0 && (number & (-number)) == number;
    }
}