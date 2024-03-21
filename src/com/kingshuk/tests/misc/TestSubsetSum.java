package com.kingshuk.tests.misc;

public class TestSubsetSum {
    public static void main ( String[] args ) {
        int[] arr = { 1, 2, 3, 5 };
        int sum = 8;
        int n = arr.length;
        System.out.println ( printNumberOfSubset ( arr, sum, n ) );
    }

    // complexity=theta(2^n)
    // total nodes of recursion trees = 2^n + 2^n - 1
    private static int printNumberOfSubset ( int[] arr, int sum, int n ) {
        if ( n == 0 )
            return sum == 0 ? 1 : 0;
        if ( arr[n - 1] > sum )
            return printNumberOfSubset ( arr, sum, n - 1 );
        return printNumberOfSubset ( arr, sum, n - 1 ) + printNumberOfSubset ( arr, sum - arr[n - 1], n - 1 );
    }
}
