package com.kingshuk.tests.DynamicProgramming;

public class MinimumInsertionToMakePalindrome {
    public static int minInsertion ( String str ) {
        int x = findLongestPalindromicSubsequence ( str );
        return str.length () - x;
    }

    private static int findLongestPalindromicSubsequence ( String s ) {
        int n = s.length ();
        int[] dp = new int[n + 1];
        String s1 = new StringBuilder ( s ).reverse ().toString ();
        for ( int i = 0; i <= n; i++ ) {
            int[] cur = new int[n + 1];
            for ( int j = 0; j <= n; j++ ) {
                if ( i == 0 || j == 0 ) {
                    cur[j] = 0;
                } else if ( s.charAt ( i - 1 ) == s1.charAt ( j - 1 ) ) {
                    cur[j] = 1 + dp[j - 1];
                } else {
                    cur[j] = Math.max ( cur[j - 1], dp[j] );
                }
            }
            dp = cur;
        }
        return dp[n];
    }
}