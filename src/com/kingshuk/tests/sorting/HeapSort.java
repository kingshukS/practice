package com.kingshuk.tests.sorting;

import java.util.Arrays;

import static com.kingshuk.tests.sorting.HoarePartition.swap;

public class HeapSort {
    public static void main ( String[] args ) {
        int[] arr = { 4, 15, 20, 50, 10 };
        applyHeapSort ( arr );
        System.out.println ( Arrays.toString ( arr ) );
    }

    private static void applyHeapSort ( int[] arr ) {
        int n = arr.length;
        buildMaxHeap ( arr );
        for ( int i = n - 1; i >= 1; i-- ) {
            swap ( arr, 0, i );
            maxHeapify ( arr, i, 0 );
        }
    }

    private static void buildMaxHeap ( int[] arr ) {
        int n = arr.length;
        for ( int i = ( n - 2 ) / 2; i >= 0; i-- ) {
            maxHeapify ( arr, n, i );
        }
    }

    private static void maxHeapify ( int[] arr, int n, int i ) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if ( left < n && arr[left] > arr[largest] )
            largest = left;
        if ( right < n && arr[right] > arr[largest] )
            largest = right;
        if ( largest != i ) {
            swap ( arr, largest, i );
            maxHeapify ( arr, n, largest );
        }
    }
}
