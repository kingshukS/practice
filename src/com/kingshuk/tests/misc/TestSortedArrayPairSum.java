package com.kingshuk.tests.misc;

import java.util.Arrays;

public class TestSortedArrayPairSum {
    public static void main ( String[] args ) {
        int[] A = { 1, 4, 45, 6, 10, 8, 12 };
        int n = 16;
        Arrays.sort ( A );
        printPairsSorted ( A, n );
    }

    private static void printPairsSorted ( int[] a, int n ) {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            if ( a[low] + a[high] == n ) {
                System.out.println ( "[" + a[low] + "," + a[high] + "]" );
                low++;
                high--;
            } else if ( a[low] + a[high] > n ) {
                high--;
            } else {
                low++;
            }
        }
    }
}
