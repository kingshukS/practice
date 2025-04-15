package com.kingshuk.tests.sorting;

import static com.kingshuk.tests.sorting.LomutoPartition.swap;

/**
 * Hoare's partitioning algorithm is a partitioning algorithm that is used in the quicksort algorithm.
 * It is named after the British computer scientist Charles Antony Richard Hoare, who developed it in 1960.
 * The algorithm works by selecting a pivot element from the array and partitioning the array into two parts:
 * elements less than the pivot and elements greater than the pivot.
 * The partitioning is done in such a way that the pivot element is placed in its final position in the sorted array.
 */
public class HoarePartition {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int p = 6;
        int l = 0;
        int h = 6;
        int index = applyHoarePartition(arr, l, h, p);
        System.out.println("Partition Index:" + index);
    }

    /**
     * Hoare's partitioning algorithm
     *
     * @param arr The array to be partitioned
     * @param l   The starting index of the array
     * @param h   The ending index of the array
     * @param p   The pivot index
     * @return The index of the pivot after partitioning
     */
    public static int applyHoarePartition(int[] arr, int l, int h, int p) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If two pointers met or cross eac other
            if (i >= j)
                return j;
            swap(arr, i, j);
        }
    }
}
