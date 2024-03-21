package com.kingshuk.tests.JustPractice;

import java.util.Arrays;

public class Merge2ArraysWithO1 {

    static void mergerArrays ( int[] arr1, int m, int[] arr2, int n ) {

        for ( int i = n - 1; i >= 0; i-- ) //arr2
        {
            int j, last = arr1[m - 1];
            for ( j = m - 2; j >= 0 && arr1[j] > arr2[i]; j-- ) //arr1
                arr1[j + 1] = arr1[j];
            if ( j != m - 2 || last > arr2[i] ) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
        System.out.println ( Arrays.toString ( arr1 ) );
        System.out.println ( Arrays.toString ( arr2 ) );
    }

    public static void main ( String[] args ) {
        int[] arr1 = { 1, 5, 9, 10, 15, 20 };
        int[] arr2 = { 2, 3, 8, 13 };
        int m = arr1.length;
        int n = arr2.length;
        mergerArrays ( arr1, m, arr2, n );
    }
}
