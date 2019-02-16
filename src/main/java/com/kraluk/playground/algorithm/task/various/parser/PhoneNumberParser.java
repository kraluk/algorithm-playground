package com.kraluk.playground.algorithm.task.various.parser;

/**
 * Simple Phone Number Parser
 * <br/>
 * Input string could contain spaces, dashes and at least two numbers.
 * <br/>
 * Output string should be in the format 000-000-000 or in specific case 000-000-00-00.
 *
 * @author lukasz
 */
public class PhoneNumberParser {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String EMPTY = "";

    private static final int DOUBLE_DOUBLE_CHARS = 4;

    public static String parse(String input) {
        String preparedInput = prepareInput(input);
        char[] preparedInputs = preparedInput.toCharArray();

        if (preparedInput.length() == DOUBLE_DOUBLE_CHARS) {
            return prepareDoubleDouble(preparedInputs).toString();
        }

        boolean isDoubleDouble = isDoubleDoubleEnded(preparedInput);

        int length = isDoubleDouble
            ? preparedInput.length() - DOUBLE_DOUBLE_CHARS : preparedInput.length();

        StringBuilder result = prepareOutput(preparedInputs, length);

        if (isDoubleDouble) {
            result.append(DASH).append(prepareDoubleDouble(preparedInputs));
        }

        return result.toString();
    }

    private static String prepareInput(String input) {
        return input.trim().replace(SPACE, EMPTY).replace(DASH, EMPTY);
    }

    /**
     * Will the given string be in the format 000-000-00-00?
     */
    private static boolean isDoubleDoubleEnded(String input) {
        return (input.length() - 4) % 3 == 0;
    }

    private static StringBuilder prepareOutput(char[] input, int length) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(input[i]);

            if ((i + 1) % 3 == 0 && (i + 1) != length) {
                result.append(DASH);
            }
        }

        return result;
    }

    private static StringBuilder prepareDoubleDouble(char[] input) {
        StringBuilder result = new StringBuilder();

        int length = input.length;
        int baseArrayIndex = length - DOUBLE_DOUBLE_CHARS;

        for (int i = 0; i < DOUBLE_DOUBLE_CHARS; i++) {
            int index = baseArrayIndex + i;
            result.append(input[index]);

            if ((i + 1) % 2 == 0 && (index + 1) != length) {
                result.append(DASH);
            }
        }

        return result;
    }
}