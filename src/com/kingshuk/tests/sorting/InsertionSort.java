package com.kingshuk.tests.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        applyInsertionSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void applyInsertionSort(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void applyInsertionSort2(int[] arr) {
        if (arr.length < 2) return;
        applyInsertionSortRecursive(arr, 1, arr.length);
    }


    private static void applyInsertionSortRecursive(int[] arr, int index, int n) {
        if (index >= n) return;
        int key = arr[index];
        int j = index - 1;
        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        applyInsertionSortRecursive(arr, index + 1, n);
    }
}
