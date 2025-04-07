package com.kingshuk.tests.sorting;

// Selection sort algorithm
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        applySelectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Selection sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void applySelectionSort(int[] arr) {
        int n = arr.length;
        // last element will always be sorted with length 1
        for (int i = 0; i < n - 1; i++) {
            int min_ind = i;
            // find the minimum element index from the unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_ind])
                    min_ind = j;
            }
            // swap the elements when minimum element found
            if (min_ind != i) {
                int temp = arr[min_ind];
                arr[min_ind] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
