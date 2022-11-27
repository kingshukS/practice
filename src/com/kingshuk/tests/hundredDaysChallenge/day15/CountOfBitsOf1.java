package com.kingshuk.tests.hundredDaysChallenge.day15;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountOfBitsOf1 {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];
        setBits[0] = 0;

        for (int i = 1; i <= n; i++) {
            setBits[i] = (i % 2 == 0)? setBits[i / 2] : setBits[i - 1] + 1;
        }

        return setBits;
    }
}
