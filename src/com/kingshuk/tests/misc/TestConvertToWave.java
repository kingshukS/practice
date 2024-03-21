package com.kingshuk.tests.misc;

public class TestConvertToWave {
    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6 };
        int n = arr.length;
        for ( int i = 0; i < n - 1; i = i + 2 ) {
            int t = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = t;
        }
        for ( int i : arr )
            System.out.print ( i + " " );
    }
}
