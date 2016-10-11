package com.kraluk.playground.algorithm.euler;

import lombok.extern.slf4j.Slf4j;

import static com.kraluk.playground.algorithm.util.Maths.isPalindrome;

/**
 * Finds largest palindrome product of multiplication of 3-digits number
 *
 * @author lukasz
 */
@Slf4j
public class LargestPalindromeProduct {

    public static long calculate(int digits) {
        if (digits < 2) {
            throw new IllegalArgumentException("");
        }

        long min = (long) Math.pow(10, digits - 1);
        long max = (long) Math.pow(10, digits) - 1;

        long result = 0;

        for (long i = min; i <= max; i++) {
            for (long j = max; j >= min; j--) {
                long calc = i * j;

                if (isPalindrome(calc)) {
                    if (calc > result) {
                        log.info("Palindrome pair '{}' '{}' produces result '{}'", i, j, calc);
                        result = calc;
                    }
                }
            }
        }

        return result;
    }

    public static long calculateBasic(int digits) {
        // TODO: implement this!
        return 0;
    }

    public static long calculateImproved(int digits) {
        // TODO: implement this!
        return 0;
    }

    public static long calculateOptimized(int digits) {
        // TODO: implement this!
        return 0;
    }
}