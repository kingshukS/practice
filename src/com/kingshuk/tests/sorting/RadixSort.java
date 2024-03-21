package com.kingshuk.tests.sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main ( String[] args ) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        radixSort ( arr );
        System.out.println ( Arrays.toString ( arr ) );
    }

    public static void radixSort ( int[] arr ) {
        int n = arr.length;
        if ( n > 0 ) {
            int maximum = arr[0];
            for ( int i = 1; i < n; i++ )
                maximum = Math.max ( maximum, arr[i] );

            for ( int exp = 1; maximum / exp > 0; exp = exp * 10 ) {
                radixSortUtil ( arr, exp );
            }
        }
    }

    private static void radixSortUtil ( int[] arr, int exp ) {
        int n = arr.length;
        int[] count = new int[10];
        int[] output = new int[n];
        for ( int i = 0; i < n; i++ ) {
            count[( arr[i] / exp ) % 10]++;
        }
        for ( int i = 1; i < count.length; i++ ) {
            count[i] = count[i] + count[i - 1];
        }

        for ( int i = n - 1; i >= 0; i-- ) {
            output[count[( arr[i] / exp ) % 10] - 1] = arr[i];
            count[( arr[i] / exp ) % 10]--;
        }

        System.arraycopy ( output, 0, arr, 0, n );
    }
}
