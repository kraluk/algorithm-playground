package com.kraluk.playground.algorithm.string;

import com.kraluk.playground.algorithm.enums.CaseType;

/**
 * Simple String Operations
 *
 * @author lukasz
 */
public class Strings {

    public static String reverse(String input) {
        char[] string = input.toCharArray();
        char[] reverseString = new char[input.length()];

        for (int i = input.length() - 1, j = 0; i >= 0; i--, j++) {
            reverseString[j] = string[i];
        }

        return new String(reverseString);
    }

    public static boolean isCapital(String input) {
        return Character.isUpperCase(input.charAt(0));
    }

    public static CaseType isUpperOrLower(String input) {
        char firstCharacter = input.charAt(0);
        if (Character.isUpperCase(firstCharacter)) {
            return CaseType.UPPER;
        } else if (Character.isLowerCase(firstCharacter)) {
            return CaseType.LOWER;
        } else {
            return CaseType.NA;
        }
    }

    public static String changeFirstCharacter(String input) {
        char firstCharacter = input.charAt(0);
        if (Character.isUpperCase(firstCharacter)) {
            return input
                .replaceFirst("^[A-Z]{1}", String.valueOf(Character.toLowerCase(firstCharacter)));
        } else if (Character.isLowerCase(firstCharacter)) {
            return input
                .replaceFirst("^[a-z]{1}", String.valueOf(Character.toUpperCase(firstCharacter)));
        } else {
            return "";
        }
    }

    public static String justifyLeft(String input, int length) {
        if (input.length() >= length) {
            return input;
        }

        int blankLength = length - input.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < blankLength; i++) {
            result.append(" ");
        }

        result.append(input);

        return result.toString();
    }

    public static String justifyRight(String input, int length) {
        if (input.length() >= length) {
            return input;
        }

        int blankLength = length - input.length();

        StringBuilder result = new StringBuilder(input);

        for (int i = 0; i < blankLength; i++) {
            result.append(" ");
        }

        return result.toString();
    }
}
