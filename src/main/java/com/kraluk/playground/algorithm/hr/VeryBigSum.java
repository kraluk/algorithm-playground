package com.kraluk.playground.algorithm.hr;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Sums very big integers
 *
 * @author lukasz
 */
public class VeryBigSum {
    private static final String SPLIT = "\\s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int size = Integer.parseInt(scanner.nextLine().trim());
            String array = scanner.nextLine().trim();

            System.out.println(calculate(array));
        }
    }

    public static long calculate(String input) {
        return Arrays.stream(input.split(SPLIT))
            .map(Long::valueOf)
            .collect(Collectors.toList())
            .stream()
            .mapToLong(Long::longValue)
            .sum();
    }
}