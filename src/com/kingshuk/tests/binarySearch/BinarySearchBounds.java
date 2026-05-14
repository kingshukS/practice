package com.kingshuk.tests.binarySearch;

public class BinarySearchBounds {

    /**
     * Finds the lower bound (first occurrence) of a target value in a sorted array.
     * <p>
     * This method returns the index of the first element that is greater than or equal to
     * the target value {@code b}. If no such element exists, it returns {@code arr.length}
     * (i.e. the insertion position at the end).
     * Uses binary search algorithm with O(log n) time complexity.
     * </p>
     *
     * @param arr the sorted array of integers (must be sorted in ascending order)
     * @param b   the target value to find the lower bound for
     * @return the index of the first element >= {@code b}, or {@code arr.length} if no such element exists
     *
     * @throws NullPointerException if arr is null
     *
     * @example
     * int[] arr = {1, 2, 2, 2, 3, 4, 5};
     * int lb = lowerBound(arr, 2);  // returns 1 (first index where arr[i] >= 2)
         * int lb2 = lowerBound(arr, 10); // returns arr.length (no element >= 10)
     * int lb3 = lowerBound(arr, 0);  // returns 0 (first element >= 0)
     */
    public static int lowerBound( int[] arr, int b ) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] < b) {
                low = mid+1;
            } else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }


    /**
     * Finds the upper bound (first element strictly greater than target) in a sorted array.
     * <p>
     * This method returns the index of the first element that is strictly greater than
     * the target value {@code b}. If no such element exists, it returns {@code arr.length}
     * (i.e. insertion position at the end).
     * Uses binary search algorithm with O(log n) time complexity.
     * </p>
     *
     * @param arr the sorted array of integers (must be sorted in ascending order)
     * @param b   the target value to find the upper bound for
     * @return the index of the first element > {@code b}, or {@code arr.length} if no such element exists
     *
     * @throws NullPointerException if arr is null
     *
     * @example
     * int[] arr = {1, 2, 2, 2, 3, 4, 5};
     * int ub = upperBound(arr, 2);   // returns 4 (first index where arr[i] > 2)
         * int ub2 = upperBound(arr, 10); // returns arr.length (no element > 10)
     * int ub3 = upperBound(arr, 0);  // returns 0 (first element > 0)
     */
    public static int upperBound( int[] arr, int b ) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] <= b) {
                low = mid+1;
            } else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
