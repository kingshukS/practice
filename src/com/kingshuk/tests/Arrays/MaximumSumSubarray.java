package com.kingshuk.tests.Arrays;

public class MaximumSumSubarray {

    public static void main ( String[] args ) {
        int[] arr = new int[]{ - 2, - 3, 4, - 1, - 2, 1, 5, - 3 };
        maxSubarray ( arr );
    }

    static void maxSubarray ( int[] arr ) {
        int n = arr.length;
        int sum_till_now = 0;
        int maxSumSofar = 0;
        int start = 0;
        int s = 0;
        int end = 0;
        for ( int i = 0; i < n; i++ ) {
            sum_till_now = sum_till_now + arr[i];
            if ( maxSumSofar < sum_till_now ) {
                maxSumSofar = sum_till_now;
                start = s;
                end = i;
            }

            if ( sum_till_now < 0 ) {
                sum_till_now = 0;
                s = i + 1;
            }
        }
        System.out.println ( "The max sum is " + maxSumSofar + " from index " + start + " to " + end );

    }
}
