package com.kingshuk.tests.hundredDaysChallenge.day16;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInIndex {
    public int searchInsert ( int[] nums, int target ) {
        int low = 0;
        int high = nums.length - 1;
        int index = - 1;
        while (low <= high) {
            int mid = low + ( high - low ) / 2;
            if ( nums[mid] == target )
                return mid;
            else if ( nums[mid] < target ) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index + 1;
    }
}
