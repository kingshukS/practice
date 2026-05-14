package com.kingshuk.tests.binarySearch;

import static com.kingshuk.tests.binarySearch.BinarySearchBounds.lowerBound;
import static com.kingshuk.tests.binarySearch.BinarySearchBounds.upperBound;

public class FirstAndLastOccurrence {

    /**
     * Finds the first and last occurrence indices of a target value in a sorted array.
     * <p>
     * Uses the {@code lowerBound} and {@code upperBound} helpers:
     * - {@code lowerBound(arr, b)} returns the index of the first element >= b (or {@code arr.length} if none)
     * - {@code upperBound(arr, b)} returns the index of the first element > b (or {@code arr.length} if none)
     * </p>
     * <p>
     * The method returns an int[] of length 2: {firstIndex, lastIndex}. If the target
     * value {@code b} is not present in the array the method returns {-1, -1}.
     * </p>
     *
     * Time complexity: O(log n) (two binary searches), Space complexity: O(1).
     *
     * @param arr the sorted array of integers (must be sorted in ascending order)
     * @param b   the target value to search for
     * @return an int[] containing {firstIndex, lastIndex} of {@code b} in {@code arr}, or {-1, -1}
     *         if {@code b} is not present
     * @throws NullPointerException if {@code arr} is null
     *
     * @example
     * int[] arr = {1, 2, 2, 2, 3};
     * findFirstAndLastOccurrence(arr, 2); // returns {1, 3}
     * findFirstAndLastOccurrence(arr, 4); // returns {-1, -1}
     */
    public static int[] findFirstAndLastOccurrence ( int[] arr, int b ) {
        int firstOccurrence = lowerBound(arr, b);
        if (firstOccurrence == arr.length || arr[firstOccurrence] != b) {
            return new int[]{-1, -1};
        }
        int lastOccurrence = upperBound(arr, b) - 1;
        return new int[]{firstOccurrence, lastOccurrence};
    }
}
