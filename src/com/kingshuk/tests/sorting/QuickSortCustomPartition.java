package com.kingshuk.tests.sorting;

import java.util.Arrays;

import static com.kingshuk.tests.sorting.LomutoPartition.swap;

/**
 * Quick sort algorithm with custom partitioning
 * <p>
 * This implementation uses a custom partitioning algorithm to sort an array of integers.
 * The partitioning algorithm is based on the custom partition scheme.
 * <p>
 * Time complexity: O(n log n)
 * Space complexity: O(log n)
 */
public class QuickSortCustomPartition {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        // Custom partitioning
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    /**
     * Quick sort algorithm
     * Time complexity: O(n log n)
     * Space complexity: O(log n)
     *
     * @param arr the array to be sorted
     * @param lo  the starting index of the array
     * @param hi  the ending index of the array
     */
    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    /**
     * Custom partitioning algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     * @param lo  the starting index of the array
     * @param hi  the ending index of the array
     * @return the pivot index
     */
    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int start = lo;
        int end = hi;
        while (start < end) {
            while (arr[start] <= pivot && start < hi) {
                start++;
            }
            while (arr[end] > pivot && end > lo) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, lo, end);
        return end;
    }
}
