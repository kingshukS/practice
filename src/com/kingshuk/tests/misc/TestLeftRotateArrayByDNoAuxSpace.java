package com.kingshuk.tests.misc;

public class TestLeftRotateArrayByDNoAuxSpace {
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
        reverse ( arr, 0, d - 1 );
        reverse ( arr, d, n - 1 );
        reverse ( arr, 0, n - 1 );
    }

    private static void reverse ( int[] arr, int l, int h ) {
        while (l < h) {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
            l++;
            h--;
        }
    }
}
