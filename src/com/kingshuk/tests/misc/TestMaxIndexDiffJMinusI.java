package com.kingshuk.tests.misc;

// Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
public class TestMaxIndexDiffJMinusI {
    public static void main ( String[] args ) {
        int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        int n = arr.length;
        System.out.println ( "Maximum Index Diff:" + findMaximumIndexDiff ( arr, n ) );
    }

    private static int findMaximumIndexDiff ( int[] arr, int n ) {
        int maxDiff = - 1;
        int[] LMin = new int[n];
        int[] RMax = new int[n];
        LMin[0] = arr[0];
        RMax[n - 1] = arr[n - 1];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        for ( int i = 1; i < n; i++ ) {
            LMin[i] = Math.min ( arr[i], LMin[i - 1] );
        }

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        for ( int i = n - 2; i >= 0; i-- ) {
            RMax[i] = Math.max ( arr[i], RMax[i + 1] );
        }

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if ( LMin[i] < RMax[j] ) {
                maxDiff = Math.max ( maxDiff, j - i );
                j = j + 1;
            } else {
                i = i + 1;
            }
        }
        return maxDiff;
    }
}
