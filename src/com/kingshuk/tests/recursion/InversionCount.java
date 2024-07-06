package com.kingshuk.tests.recursion;

import java.util.Arrays;

class InversionCount {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount ( long[] arr, long N ) {
        return mergeSort ( arr, 0, (int) ( N - 1 ) );
    }

    private static long mergeSort ( long[] arr, int l, int r ) {
        long count = 0L;
        if ( l >= r )
            return count;

        int m = l + ( r - l ) / 2;
        count += mergeSort ( arr, l, m );
        count += mergeSort ( arr, m + 1, r );
        count += mergeAndCount ( arr, l, m, r );

        return count;
    }

    private static long mergeAndCount ( long[] arr, int l, int m, int r ) {
        long swaps = 0L;
        long[] left = Arrays.copyOfRange ( arr, l, m + 1 );
        long[] right = Arrays.copyOfRange ( arr, m + 1, r + 1 );

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if ( left[i] <= right[j] ) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += left.length - i;
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    public static void main ( String[] args ) {
        long N = 5;
        long[] arr = { 2, 3, 4, 5, 6 };
        System.out.println ( inversionCount ( arr, N ) );
    }
}