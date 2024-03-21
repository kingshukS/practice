package com.kingshuk.tests.hundredDaysChallenge.day2;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears
 * at most twice. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part
 * of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the
 * final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main ( String[] args ) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4 };
        int k = 2;
        int num = removeDuplicates2 ( nums, k );
        for ( int i = 0; i < num; i++ ) {
            System.out.print ( nums[i] + " " );
        }
    }

    public static int removeDuplicates2 ( int[] nums, int k ) {
        if ( nums.length <= k )
            return nums.length;
        int i = k;
        for ( int j = i; j < nums.length; j++ ) {
            if ( nums[i - k] != nums[j] ) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
