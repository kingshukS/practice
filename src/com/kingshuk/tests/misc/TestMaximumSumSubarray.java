package com.kingshuk.tests.misc;

public class TestMaximumSumSubarray {
    public static void main ( String[] args ) {
        int[] arr = { 2, 3, - 8, 7, - 1, 2, 3 };
        int n = arr.length;
        int max = findMaximumSumSubarray ( arr, n );
        int max2 = findMaximumSumSubarray ( arr );
        System.out.println ( "Maximum Sum is:" + max );
        System.out.println ( "Maximum Sum is:" + max2 );
    }

    private static int findMaximumSumSubarray ( int[] arr, int n ) {
        int max_sum = arr[0];
        int cur_sum = 0;
        int s = 0, start = 0, end = 0;
        for ( int i = 0; i < n; i++ ) {
            cur_sum += arr[i];
            if ( cur_sum > max_sum ) {
                max_sum = cur_sum;
                start = s;
                end = i;
            }
            if ( cur_sum < 0 ) {
                cur_sum = 0;
                s = i + 1;
            }
        }
        System.out.println ( "Start: " + start + " End: " + end );
        return max_sum;
    }

    private static int findMaximumSumSubarray ( int[] arr ) {
        int n = arr.length;
        int max_sum = arr[0];
        int pre_max = 0;
        for ( int i = 0; i < n; i++ ) {
            max_sum = Math.max ( arr[i], pre_max + arr[i] );
            pre_max = max_sum;
        }
        return max_sum;
    }
}
