package com.kingshuk.tests.hundredDaysChallenge.day3;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class MountainArray {
    public static void main ( String[] args ) {
        int[] arr = { 0, 3, 2, 1 };
        boolean isMountainArray = isMountainArray ( arr );
        System.out.println ( "Is it a mountain array: " + isMountainArray );
    }

    private static boolean isMountainArray ( int[] arr ) {
        int n = arr.length;
        if ( n < 3 )
            return false;
        int left = 0;
        int right = n - 1;
        /* At least one downtrend towards right, as we are checking for left and left+1, the max index of the top is n-2,
         then left value can reach at most n-3, when doing left++, it will reach n-2 then.*/
        while (left <= n - 3 && arr[left] < arr[left + 1]) left++;
        /* At least one downtrend towards left, as we are checking for right and right-1, the min index of the top is 1,
         then right value can reach at most 2, when doing right++, it will reach 1 then.*/
        while (right >= 2 && arr[right] < arr[right - 1]) right--;
        return left == right;
    }
}
