package com.kingshuk.tests.misc;

public class TestMaximumSumSubarrayCircular {
    public static void main ( String[] args ) {
        int[] arr = { 8, - 4, 3, - 5, 4 };
        int n = arr.length;
        int max = findMaximumSumSubarrayCircular ( arr, n );
        System.out.println ( "Maximum Sum is:" + max );
    }

    private static int findMaximumSumSubarrayCircular ( int[] arr, int n ) {
        // normal Kadane's algorithm to find normal max sum sub-array
        int maxSumNormal = findMaximumSumSubarray ( arr, n );

        // if all the elements are -ve, there is no need of calculating circular sum
        if ( maxSumNormal < 0 ) {
            return maxSumNormal;
        }
        int arrSum = 0;
        for ( int i = 0; i < n; i++ ) {
            arrSum += arr[i];
            // inverting all the elements to calculate the minimum sum
            arr[i] = - arr[i];
        }
        // max circular sum sub-array = arrSum - min sub-array sum
        // => max circular sum = arrSum + max sub-array sum using normal kadane's(with inverted array elements)
        int maxSumCircular = arrSum + findMaximumSumSubarray ( arr, n );

        // result is maximum of max normal sum sub-array and max circular sum sub-array
        return Math.max ( maxSumNormal, maxSumCircular );
    }

    private static int findMaximumSumSubarray ( int[] arr, int n ) {
        int maxSum = arr[0];
        int maxEnding = arr[0];
        for ( int i = 1; i < n; i++ ) {
            maxEnding = Math.max ( maxEnding + arr[i], arr[i] );
            maxSum = Math.max ( maxEnding, maxSum );
        }
        return maxSum;
    }
}
