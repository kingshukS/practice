package com.kingshuk.tests.misc;

public class TestLeftRotateArrayByD {
    public static void main ( String[] args ) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int d = 2;
        int n = arr.length;
        doRotateLeft ( arr, n, d );
        for ( int i : arr ) {
            System.out.print ( i + " " );
        }
    }

    private static void doRotateLeft ( int[] arr, int n, int d ) {
        int[] arr2 = new int[d];
        System.arraycopy ( arr, 0, arr2, 0, d );

        for ( int i = d; i < n; i++ ) {
            arr[i - d] = arr[i];
        }

        System.arraycopy ( arr2, 0, arr, n - d, d );
    }
}
