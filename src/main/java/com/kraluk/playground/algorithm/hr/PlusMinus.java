package com.kraluk.playground.algorithm.hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Counts ratios of given positive, negative numbers and zeross
 *
 * @author lukasz
 */
public class PlusMinus {
    private static final String SPLIT = "\\s";

    private static final int RESULT_SIZE = 3;
    private static final int POSITIVE_INDEX = 0;
    private static final int NEGATIVE_INDEX = 1;
    private static final int ZEROS_INDEX = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int size = Integer.parseInt(scanner.nextLine().trim());
            String input = scanner.nextLine().trim();

            int[] ints = parseInput(input);
            double[] result = calculate(size, ints);

            Arrays.stream(result).forEach(e -> System.out.format("%.6f\n", e));
        }
    }

    public static double[] calculate(int size, int[] input) {
        double[] result = new double[RESULT_SIZE];

        for (int i : input) {
            if (i > 0) {
                result[POSITIVE_INDEX]++;
            } else if (i < 0) {
                result[NEGATIVE_INDEX]++;
            } else {
                result[ZEROS_INDEX]++;
            }
        }

        return Arrays.stream(result)
            .map(e -> e / size)
            .toArray();
    }

    public static int[] parseInput(String input) {
        return Arrays.stream(input.split(SPLIT))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}