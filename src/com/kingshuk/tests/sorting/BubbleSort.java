package com.kingshuk.tests.sorting;

// Bubble sort algorithm
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        applyBubbleSortRecursive(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Bubble sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void applyBubbleSort(int[] arr) {
        boolean swapped;
        int n = arr.length;
        if (n < 2)
            return;
        // last element will be in correct place automatically, 0 to n-2 i.e. n-1 iterations
        for (int j = 0; j < n - 1; j++) {
            swapped = false;
            for (int i = 0; i < n - j - 1; i++) {
                // swap if the element is greater than the adjacent element
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            // if no two elements were swapped in the inner loop, then break
            // the array is already sorted -> best case O(n)
            if (!swapped)
                break;
        }
    }

    public static void applyBubbleSortRecursive(int[] arr, int n) {
        if (n < 2)
            return;
        boolean swapped = false;
        // last element will be in correct place automatically, 0 to n-2 i.e. n-1 iterations
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped)
            return;

        applyBubbleSortRecursive(arr, n - 1);
    }
}
