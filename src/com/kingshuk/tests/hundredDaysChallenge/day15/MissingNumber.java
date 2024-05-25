package com.kingshuk.tests.hundredDaysChallenge.day15;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public int missingNumber ( int[] nums ) {
        int n = nums.length;
        for (int i = 0; i < n; i++ ) {
            int index = nums[i];
            while (index >= 0 && index <= n - 1 && nums[index] != nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index = nums[i];
            }
        }
        for (int i = 0; i < n; i++ ) {
            if ( nums[i] != i )
                return i;
        }
        return n;
    }
}
