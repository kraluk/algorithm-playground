package com.kraluk.playground.algorithm.hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Calculates the absolute diagonal difference of a given NxN matrix
 *
 * @author lukasz
 */
public class DiagonalDifference {
    private static final String SPLIT = "\\s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int size = Integer.parseInt(scanner.nextLine().trim());

            String[] input = new String[size];

            for (int i = 0; i < size; i++) {
                input[i] = scanner.nextLine().trim();
            }

            int[][] matrix = parseInput(input);
            System.out.println(calculate(size, matrix));
        }
    }

    public static int calculate(int size, int[][] matrix) {

        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[j][i];
        }

        return Math.abs(firstDiagonal - secondDiagonal);
    }

    public static int[][] parseInput(String[] input) {
        int[][] result = new int[input.length][input.length];
        int index = 0;

        for (String line : input) {
            int[] ints = Arrays.stream(line.split(SPLIT))
                .mapToInt(Integer::parseInt)
                .toArray();

            result[index++] = ints;
        }

        return result;
    }
}