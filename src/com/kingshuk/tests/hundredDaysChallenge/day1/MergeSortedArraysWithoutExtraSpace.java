package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {

    public static void main ( String[] args ) {
        int[] arr1 = new int[]{ 1, 5, 9, 10, 15, 20 };
        int[] arr2 = new int[]{ 2, 3, 8, 13 };
        mergeArrays ( arr1, arr2 );
    }

    static void mergeArrays(int[] a, int[] b) {
        // Traverse b[] starting from the last element
        for (int i = b.length - 1; i >= 0; i--) {
            // If b[i] is smaller than the largest element of a[]
            if (a[a.length - 1] > b[i]) {

                // Place b[i] in the correct position in a[],
                // and move last element of a[] to b[]
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
        System.out.println ( "arrays after sorting " + Arrays.toString ( a ) + " " + Arrays.toString ( b ) );
    }
}
