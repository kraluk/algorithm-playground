package com.kraluk.playground.algorithm.hr;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * Calculates simple array sum
 *
 * @author lukasz
 */
public class SimpleArraySum {
    private static final String SPLIT = "\\s";

    /* ----- Classic solution ----- */

    public static class Classic {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {

                int size = Integer.parseInt(scanner.nextLine().trim());
                String array = scanner.nextLine().trim();

                System.out.println(calculate(array, size));
            }
        }

        public static int calculate(String input, int size) {
            List<Integer> integers = tokenizeInput(input);

            if (size != integers.size()) {
                throw new IllegalArgumentException("Size does not match!");
            }

            return sum(integers);
        }

        protected static int sum(List<Integer> input) {
            LongAdder adder = new LongAdder();
            input.parallelStream().forEach(adder::add);
            return adder.intValue();
        }

        protected static List<Integer> tokenizeInput(String input) {
            return Arrays.stream(input.split(SPLIT))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        }
    }

    /* ----- Compact solution ----- */

    public static class Compact {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {

                int size = Integer.parseInt(scanner.nextLine().trim());
                String array = scanner.nextLine().trim();

                System.out.println(calculate(array));
            }
        }

        public static int calculate(String input) {
            return Arrays.stream(input.split(SPLIT))
                .map(Integer::valueOf)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        }
    }
}