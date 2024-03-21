package com.kingshuk.tests.sorting;

public class HybridPartition {
    public static int hybridPartition ( int[] arr, int lo, int hi ) {
        int pivot = arr[lo];
        int start = lo;
        int end = hi;
        while (start < end) {
            while (arr[start] <= pivot)
                start++;
            while (arr[end] > pivot)
                end--;
            if ( start < end ) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        int temp = arr[lo];
        arr[lo] = arr[end];
        arr[end] = temp;

        return end;
    }
}
