package com.kingshuk.tests.sorting;

import java.util.Arrays;

// Insertion sort algorithm
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        applyInsertionSortRecursive(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Insertion sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void applyInsertionSortWithSwap(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Insertion sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void applyInsertionSort(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1], that are greater than key,
            // best case O(n)
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Insertion sort algorithm with recursion
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void applyInsertionSortRecursive(int[] arr) {
        if (arr.length < 2) return;
        applyInsertionSortRecursive(arr, 1, arr.length);
    }


    private static void applyInsertionSortRecursive(int[] arr, int index, int n) {
        // base case
        if (index >= n) return;
        int key = arr[index];
        int j = index - 1;
        // Move elements of arr[0..i-1], that are greater than key,
        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        // Insert key at the correct position
        arr[j + 1] = key;
        applyInsertionSortRecursive(arr, index + 1, n);
    }
}
