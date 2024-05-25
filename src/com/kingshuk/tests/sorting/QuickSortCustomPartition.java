package com.kingshuk.tests.sorting;

import java.util.Arrays;

public class QuickSortCustomPartition {
    public static void main ( String[] args ) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        quickSort ( arr, 0, arr.length - 1 );
        Arrays.stream ( arr ).forEach ( x -> System.out.print ( x + " " ) );
    }

    private static void quickSort ( int[] arr, int lo, int hi ) {
        if ( lo < hi ) {
            //int p = partition2 ( arr, lo, hi, hi );
            int p = partition ( arr, lo, hi );
            quickSort ( arr, lo, p - 1 );
            quickSort ( arr, p + 1, hi );
        }
    }

    private static int partition ( int[] arr, int lo, int hi ) {
        int pivot = arr[lo];
        int start = lo;
        int end = hi;
        while (start < end) {
            while (arr[start] <= pivot && start < hi)
                start++;
            while (arr[end] > pivot && end > lo)
                end--;
            if ( start < end ) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        int temp = arr[start-1];
        arr[start-1] = arr[lo];
        arr[lo] = temp;
        return start-1;
    }

    private static int partition2 ( int[] arr, int lo, int hi, int pivotIndex ) {
        // The Lomuto Partition
        int pivot = arr[pivotIndex];
        int i = lo -1;
        swap(arr, pivotIndex, hi);
        for ( int j = lo; j < hi; j++ ) {
            if ( arr[j] < pivot ) {
                i++;
                swap ( arr, i, j );
            }
        }
        swap ( arr, i + 1, hi );
        return i + 1;
    }

    private static void swap ( int[] arr, int i1, int i2 ) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
