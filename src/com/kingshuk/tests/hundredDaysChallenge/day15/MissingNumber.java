package com.kingshuk.tests.hundredDaysChallenge.day15;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public int missingNumber ( int[] nums ) {
        for ( int i = 0; i < nums.length; i++ ) {
            int index = nums[i];
            while (index >= 0 && index <= nums.length - 1 && nums[index] != nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index = nums[i];
            }
        }
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] != i )
                return i;
        }
        return nums.length;
    }
}
