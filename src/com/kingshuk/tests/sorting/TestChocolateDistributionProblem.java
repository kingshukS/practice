package com.kingshuk.tests.sorting;


import static com.kingshuk.tests.sorting.QuickSort.quickSort;

public class TestChocolateDistributionProblem {
    public static void main ( String[] args ) {
        int[] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
        int m = 5;
        System.out.println ( "Minimum difference between max and min:" + findDistribution ( arr, m ) );
    }

    private static int findDistribution ( int[] arr, int m ) {
        int n = arr.length - 1;
        if ( m > n )
            return - 1;
        quickSort ( arr, 0, n );
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = m - 1;
        while (end < n) {
            res = ( arr[end] - arr[start] ) < res ? ( arr[end] - arr[start] ) : res;
            end++;
            start++;
        }
        return res;
    }
}
