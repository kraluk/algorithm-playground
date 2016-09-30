package com.kraluk.playground.algorithm.euler;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kraluk.playground.algorithm.util.Multiples.getMultiples;

/**
 * Calculates sum of distinct multiples of Three and Five numbers
 *
 * @author lukasz
 */
public class MultiplesOfThreeAndFiveSummer {

    public static long calculate(long limit) {
        long result = 0;

        for (long i = 0; i < limit; i++) {
            if ((i % 3) == 0 || (i % 5) == 0) {
                result += i;
            }
        }

        return result;
    }

    public static long calculateOptimized(long limit) {
        long lastNumber = limit - 1;
        return sumDivisibleBy(3, lastNumber) + sumDivisibleBy(5, lastNumber) - sumDivisibleBy(15,
            lastNumber);
    }

    private static long sumDivisibleBy(long number, long limit) {
        long p = limit / number;
        return number * (p * (p + 1)) / 2;
    }

    // ----- Legacy Stuff (ULTRA not optimized)

    public static class Legacy {

        @Deprecated
        public static long calculate(long limit) {

            Set<Long> threeMultiples = getMultiples(3, limit);
            Set<Long> fiveMultiples = getMultiples(5, limit);

            fiveMultiples.addAll(threeMultiples);

            long result = fiveMultiples.parallelStream().mapToLong(Long::longValue).sum();

            return result;
        }

        @Deprecated
        public static long calculateWithExecutor(long limit)
            throws ExecutionException, InterruptedException {

            Future<Set<Long>> asyncThreeMultiples =
                Executors.newSingleThreadExecutor().submit(() -> getMultiples(3, limit));

            Set<Long> fiveMultiples = getMultiples(5, limit);
            Set<Long> threeMultiples = asyncThreeMultiples.get();

            fiveMultiples.addAll(threeMultiples);

            long result = fiveMultiples.parallelStream().mapToLong(Long::longValue).sum();

            return result;
        }

        @Deprecated
        public static long calculateWithCompletableFuture(long limit)
            throws ExecutionException, InterruptedException {

            Future<Set<Long>> asyncThreeMultiples =
                CompletableFuture.supplyAsync(() -> getMultiples(3, limit));

            Set<Long> fiveMultiples = getMultiples(5, limit);
            Set<Long> threeMultiples = asyncThreeMultiples.get();

            fiveMultiples.addAll(threeMultiples);

            long result = fiveMultiples.parallelStream().mapToLong(Long::longValue).sum();

            return result;
        }
    }
}