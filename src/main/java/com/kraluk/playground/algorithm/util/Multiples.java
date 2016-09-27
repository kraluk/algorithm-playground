package com.kraluk.playground.algorithm.util;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

/**
 * Multiples Common Calculation Utils
 *
 * @author lukasz
 */
@UtilityClass
public class Multiples {

    public static Set<Long> getMultiples(long number, long limit) {
        Set<Long> result = new HashSet<>();

        for (long i = 1; ; i++) {
            long multiple = number * i;

            if (multiple < limit) {
                result.add(multiple);
            } else {
                break;
            }
        }

        return result;
    }
}