package com.kingshuk.tests.misc;

public class TestArraySorted {
    public static void main ( String[] args ) {
        int[] arr = { 10, 10, 10, 12 };
        System.out.println ( "Is Sorted:" + isSorted ( arr, arr.length ) );
    }

    private static boolean isSorted ( int[] arr, int n ) {
        boolean sorted = true;
        for ( int i = 1; i < n; i++ ) {
            if ( arr[i] < arr[i - 1] ) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
