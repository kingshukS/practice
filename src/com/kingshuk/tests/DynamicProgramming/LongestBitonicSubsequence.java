package com.kingshuk.tests.DynamicProgramming;

public class LongestBitonicSubsequence {
    public static int longestBitonicSequence ( int[] arr, int n ) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for ( int i = 0; i < n; i++ ) {
            dp1[i] = 1;
            for ( int j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j] && dp1[j] + 1 > dp1[i] ) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for ( int i = n - 1; i >= 0; i-- ) {
            dp2[i] = 1;
            for ( int j = n - 1; j > i; j-- ) {
                if ( arr[i] > arr[j] && dp2[j] + 1 > dp2[i] ) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int max = 0;
        for ( int i = 0; i < n; i++ ) {
            max = Math.max ( max, dp1[i] + dp2[i] - 1 );
        }

        return max;
    }
}
