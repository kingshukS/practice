package com.kingshuk.tests.hundredDaysChallenge.day23;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaximumConsecutiveOnes {

    public static void main ( String[] args ) {
        System.out.println ( new MaximumConsecutiveOnes ().longestOnes ( new int[]{ 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2 ) );
    }

    public int longestOnes ( int[] nums, int k ) {
        int i = 0, j = 0, maxLen = Integer.MIN_VALUE;
        while (i < nums.length) {
            if ( nums[i] == 1 ) {
                i++;
            } else {
                if ( k > 0 ) {
                    k--;
                    i++;
                } else {
                    while (k <= 0) {
                        if ( nums[j] == 0 )
                            k++;
                        j++;
                    }
                }
            }
            maxLen = Math.max ( maxLen, i - j );
        }
        return maxLen;
    }

    public int longestOnesBest ( int[] nums, int k ) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if ( nums[i] == 0 )
                k--;
            if ( k < 0 ) {
                if ( nums[j] == 0 )
                    k++;
                j++;
            }
            i++;
        }
        return i - j;
    }
}
