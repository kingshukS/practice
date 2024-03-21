package com.kingshuk.tests.misc;

public class TestRightRotateArrayByDNoAuxSpace {
    public static void main ( String[] args ) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int d = 2;
        int n = arr.length;
        doRotateRight ( arr, n, d );
        for ( int i : arr ) {
            System.out.print ( i + " " );
        }
    }

    private static void doRotateRight ( int[] arr, int n, int d ) {
        reverse ( arr, n - d, n - 1 );
        reverse ( arr, 0, n - d - 1 );
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
