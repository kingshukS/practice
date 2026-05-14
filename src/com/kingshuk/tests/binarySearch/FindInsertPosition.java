package com.kingshuk.tests.binarySearch;

import static com.kingshuk.tests.binarySearch.BinarySearchBounds.lowerBound;

public class FindInsertPosition {
    
    /**
     * Finds the index where a value should be inserted into a sorted (ascending) array to
     * maintain sort order. This is the standard "lower bound" / insertion position.
     * <p>
     * The method returns the smallest index i in the range [0, arr.length] such that
     * arr[i] >= b. If all elements are less than {@code b}, the method returns
     * {@code arr.length} (meaning insertion at the end). If the array is empty, it
     * returns 0.
     * </p>
     *
     * Time complexity: O(log n), Space complexity: O(1).
     *
     * @param arr the sorted array of integers (must be sorted in ascending order)
     * @param b   the target value to find the insertion position for
     * @return the index where {@code b} should be inserted (an int in [0, arr.length])
     * @throws NullPointerException if {@code arr} is null
     *
     * @example
     * int[] arr = {1, 3, 5, 6};
     * findInsertPosition(arr, 5); // returns 2 (existing 5)
     * findInsertPosition(arr, 2); // returns 1 (insert between 1 and 3)
     * findInsertPosition(arr, 7); // returns 4 (insert at end)
     */
    public static int findInsertPosition ( int[] arr, int b ) {
       return  lowerBound(arr, b);
    }
}
