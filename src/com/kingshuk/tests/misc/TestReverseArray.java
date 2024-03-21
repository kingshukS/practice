package com.kingshuk.tests.misc;

public class TestReverseArray {
    public static void main ( String[] args ) {
        int[] arr = {};
        reverseArray ( arr, arr.length );
        for ( int i : arr ) {
            System.out.print ( i + " " );
        }
    }

    private static void reverseArray ( int[] arr, int n ) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }
}
