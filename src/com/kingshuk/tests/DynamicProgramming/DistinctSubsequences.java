package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

class DistinctSubsequences {
    public int numDistinct ( String s, String t ) {
        int n = s.length ();
        int m = t.length ();
        int[][] dp = new int[n + 1][m + 1];
        for ( int[] dpi : dp )
            Arrays.fill ( dpi, - 1 );
        return f ( n, m, s, t, dp );
    }

    private int f ( int ptr1, int ptr2, String s, String t, int[][] dp ) {
        if ( ptr2 == 0 )
            return 1;

        if ( ptr1 == 0 )
            return 0;

        if ( dp[ptr1][ptr2] != - 1 ) return dp[ptr1][ptr2];

        if ( s.charAt ( ptr1 - 1 ) == t.charAt ( ptr2 - 1 ) ) {
            return dp[ptr1][ptr2] = f ( ptr1 - 1, ptr2 - 1, s, t, dp ) + f ( ptr1 - 1, ptr2, s, t, dp );
        } else
            return dp[ptr1][ptr2] = f ( ptr1 - 1, ptr2, s, t, dp );
    }

    public int numDistinctTabulation ( String s, String t ) {
        int n = s.length ();
        int m = t.length ();
        int[][] dp = new int[n + 1][m + 1];

        for ( int i = 0; i <= n; i++ )
            dp[i][0] = 1;

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = 1; j <= m; j++ ) {
                if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) ) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][m];
    }

    public int numDistinctSpaceOptimization ( String s, String t ) {
        int n = s.length ();
        int m = t.length ();
        int[] dp = new int[m + 1];

        dp[0] = 1;

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = m; j >= 1; j-- ) {
                if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) ) {
                    dp[j] = dp[j - 1] + dp[j];
                }
                // else no need to override the value stored in dp[j] (already computed){dp[j] = dp[j] -> useless}
            }
        }

        return dp[m];
    }
}