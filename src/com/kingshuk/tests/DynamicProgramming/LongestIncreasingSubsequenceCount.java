package com.kingshuk.tests.DynamicProgramming;

public class LongestIncreasingSubsequenceCount {
    public static int findNumberOfLIS ( int[] arr ) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        int max = 1;
        for ( int i = 0; i < n; i++ ) {
            dp[i] = 1;
            count[i] = 1;
            for ( int j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j] ) {
                    if ( dp[i] < dp[j] + 1 ) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if ( dp[i] == dp[j] + 1 ) {
                        count[i] += count[j];
                    }
                }
            }

            if ( dp[i] > max ) {
                max = dp[i];
            }
        }
        int res = 0;
        for ( int i = 0; i < n; i++ ) {
            if ( dp[i] == max ) {
                res += count[i];
            }
        }
        return res;
    }
}