package com.kingshuk.tests.sorting;


import static com.kingshuk.tests.sorting.LomutoPartition.swap;

/**
 * Dutch National Flag Problem
 */
public class SegmentThreeTypesElements {
    public static void main ( String[] args ) {
        int[] arr = { 0, 1, 1, 2, 1, 2, 0, 1, 0, 1, 2, 1, 0, 2, 0 };
        sortArray ( arr );
        for ( int i = 0; i < arr.length; i++ ) {
            System.out.print ( arr[i] + " " );
        }
    }

    private static void sortArray ( int[] arr ) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        while (mid <= end) {
            if ( arr[mid] == 0 ) {
                swap ( arr, start, mid );
                start++;
                mid++;
            } else if ( arr[mid] == 1 ) {
                mid++;
            } else {
                swap ( arr, mid, end );
                end--;
            }
        }
    }
}
