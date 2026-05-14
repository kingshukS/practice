package com.kingshuk.tests.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 10));
    }

    /**
     * Performs a binary search on a sorted array to find the index of a target element.
     * <p>
     * This method uses the binary search algorithm which repeatedly divides the search interval
     * in half to locate the target value. Time complexity: O(log n).
     * </p>
     *
     * @param arr the sorted array of integers to search in (must be sorted in ascending order)
     * @param b   the target value to search for
     * @return the index of the target element if found, or -1 if not found
     *
     * @throws NullPointerException if arr is null
     *
     * @example
     * int[] arr = {1, 2, 3, 4, 5};
     * int index = binarySearch(arr, 3); // returns 2
     * int notFound = binarySearch(arr, 10); // returns -1
     */
    public static int binarySearch ( int[] arr, int b ) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == b) {
                return mid;
            }  else if (arr[mid] > b) {
                high = mid - 1;
            }  else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
