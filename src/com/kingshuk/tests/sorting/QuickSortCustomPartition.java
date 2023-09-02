package com.kingshuk.tests.sorting;

public class QuickSortCustomPartition {
    public static void main(String[] args) {
        int[] arr = {10,5,1};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {

        int pivot = arr[lo];
        int start = lo;
        int end = hi;
        while (start < end) {
            while (arr[start] <= pivot && start<= hi-1)
                start++;
            while (arr[end] > pivot && end>=lo+1)
                end--;
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        int temp = arr[end];
        arr[end] = arr[lo];
        arr[lo] = temp;
        return end;
    }
}
