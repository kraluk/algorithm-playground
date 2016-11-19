package com.kraluk.playground.algorithm.hr;

import java.util.Scanner;

/**
 * Compare ALice's and Bob's scores collected in triplets
 *
 * @author lukasz
 */
public class CompareTheTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] alices = new int[]{a0, a1, a2};
        int[] bobs = new int[]{b0, b1, b2};

        System.out.println(solve(alices, bobs));
    }

    public static String solve(int[] alices, int[] bobs) {
        int alice = 0;
        int bob = 0;

        int length = alices.length; // bobs should have the same length!

        for (int i = 0; i < length; i++) {
            if (alices[i] > bobs[i]) {
                alice++;
            } else if (alices[i] < bobs[i]) {
                bob++;
            }
        }

        return String.format("%s %s", alice, bob);
    }
}