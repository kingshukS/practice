package com.kingshuk.tests.sorting;

/**
 * Lomuto's partitioning algorithm is a simple and efficient way to partition an array around a pivot.
 * It is commonly used in the QuickSort algorithm.
 * This implementation allows you to specify the pivot index, which can be useful in certain scenarios.
 */
public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int p = 6;
        int l = 0;
        int h = 6;
        int index = applyLomutoPartition(arr, l, h, p);
        System.out.println("Partition Index:" + index);
    }

    /**
     * Lomuto's partitioning algorithm
     *
     * @param arr The array to be partitioned
     * @param l   The starting index of the array
     * @param h   The ending index of the array
     * @param p   The pivot index
     * @return The index of the pivot after partitioning
     */
    public static int applyLomutoPartition(int[] arr, int l, int h, int p) {
        if (p > h || p < l)
            return -1;

        swap(arr, p, h);

        // Falling back to Standard Lomuto
        int i = l - 1;
        int pivot = arr[h];
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, h);

        // Return the index of the pivot after partitioning
        return i;
    }

    /**
     * Swaps two elements in an array
     *
     * @param arr The array in which the elements are to be swapped
     * @param i1  The index of the first element
     * @param i2  The index of the second element
     */
    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
