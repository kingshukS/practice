package com.kingshuk.tests.hundredDaysChallenge.day3;

import java.util.Arrays;

/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for
 * each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */
public class BuildArrayPermutation {
    public static void main ( String[] args ) {
        int[] num = { 0, 2, 1, 5, 3, 4 };
        doPermutation ( num );
        System.out.println ( Arrays.toString ( num ) );
    }

    private static void doPermutation ( int[] nums ) {
        int n = nums.length;
        for ( int i = 0; i < n; i++ )
            nums[i] = nums[i] * n;
        for ( int i = 0; i < n; i++ ) {
            int index = nums[i] / n;
            int input = nums[index] / n;
            nums[i] += input;
        }
        for ( int i = 0; i < n; i++ )
            nums[i] = nums[i] % n;
    }
}
