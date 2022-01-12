package com.kingshuk.tests.sorting;

import static com.kingshuk.tests.sorting.HoarePartition.applyHoarePartition;
import static com.kingshuk.tests.sorting.LomutoPartition.applyLomutoPartition;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 70, 30, 90, 70, 40, 50, 70};
        quickSort2(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Using Lomuto's partitioning
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    // Using Hoare's partitioning
    public static void quickSort2(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition2(arr, lo, hi);
            quickSort2(arr, lo, p);
            quickSort2(arr, p + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        return applyLomutoPartition(arr,lo,hi,hi);
    }

    private static int partition2(int[] arr, int lo, int hi) {
        return applyHoarePartition(arr,lo,hi,hi);
    }
}
