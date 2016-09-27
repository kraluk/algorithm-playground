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
public class MultiplesOfThreeAndFive {

    public static long calculateSum(long limit) {
        Set<Long> threeMultiples = getMultiples(3, limit);
        Set<Long> fiveMultiples = getMultiples(5, limit);

        fiveMultiples.addAll(threeMultiples);

        long result = fiveMultiples.parallelStream().mapToLong(Long::longValue).sum();

        return result;
    }

    public static long calculateSumWithExecutor(long limit)
        throws ExecutionException, InterruptedException {

        Future<Set<Long>> asyncThreeMultiples =
            Executors.newSingleThreadExecutor().submit(() -> getMultiples(3, limit));

        Set<Long> fiveMultiples = getMultiples(5, limit);
        Set<Long> threeMultiples = asyncThreeMultiples.get();

        fiveMultiples.addAll(threeMultiples);

        long result = fiveMultiples.parallelStream().mapToLong(Long::longValue).sum();

        return result;
    }

    public static long calculateSumWithCompletableFuture(long limit)
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