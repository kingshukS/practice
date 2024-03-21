package com.kingshuk.tests.hundredDaysChallenge.day24;

import java.util.Arrays;

/**
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * You may assume the input array always has a valid answer.
 * <p>
 * <p>
 * Value Range between 0 and 5000.
 * Populate the buckets based on available values.
 * Start Iterating from the end and populate the even places with values.
 * Then populate the odd places.
 */
public class WiggleSort {
    public static void main ( String[] args ) {
        int[] nums = { 1, 5, 1, 1, 6, 4 };
        new WiggleSort ().wiggleSort ( nums );
        Arrays.stream ( nums ).forEach ( i -> System.out.print ( i + " " ) );
    }

    public void wiggleSort ( int[] nums ) {
        int[] bucket = new int[5001];

        for ( int i : nums )
            bucket[i]++;

        int max = 5000;
        boolean firstPass = true;
        for ( int i = 1; i < nums.length; i += 2 ) {
            while (bucket[max] == 0)
                max--;
            nums[i] = max;
            bucket[max]--;
            if ( firstPass && i + 2 >= nums.length ) {
                i = - 2; // want to set i = 0 but since at the end it does i+2 so making it i = -2 to get resultant = 0
                firstPass = false;
            }
        }
    }
}
