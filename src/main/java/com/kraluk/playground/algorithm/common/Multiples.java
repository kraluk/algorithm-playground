package com.kraluk.playground.algorithm.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Multiples Common Calculation Utils
 *
 * @author lukasz
 */
public final class Multiples {
    public static final long MAX_LIMIT = 1_000_000;

    @Deprecated
    public static Set<Long> getMultiples(long number, long limit) {
        checkLimit(limit);

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

    private static void checkLimit(long limit) {
        if (limit >= MAX_LIMIT) {
            throw new IllegalArgumentException(
                "Given limit overruns the maximum limit for used method!");
        }
    }
}