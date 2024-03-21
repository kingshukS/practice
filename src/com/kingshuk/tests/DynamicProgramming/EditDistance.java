package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

class EditDistance {
    public int minDistance ( String word1, String word2 ) {
        int n = word1.length ();
        int m = word2.length ();

        int[][] dp = new int[n][m];
        for ( int[] dpi : dp )
            Arrays.fill ( dpi, - 1 );

        return f ( n - 1, m - 1, word1, word2, dp );
    }

    private int f ( int i, int j, String s, String t, int[][] dp ) {

        if ( i < 0 )
            return j + 1;
        if ( j < 0 )
            return i + 1;

        if ( dp[i][j] != - 1 ) return dp[i][j];

        if ( s.charAt ( i ) == t.charAt ( j ) ) {
            return f ( i - 1, j - 1, s, t, dp );
        }

        int insert = 1 + f ( i, j - 1, s, t, dp );
        int delete = 1 + f ( i - 1, j, s, t, dp );
        int replace = 1 + f ( i - 1, j - 1, s, t, dp );

        return dp[i][j] = Math.min ( insert, Math.min ( delete, replace ) );
    }

    public int minDistanceTabulation ( String word1, String word2 ) {
        int n = word1.length ();
        int m = word2.length ();

        int[][] dp = new int[n + 1][m + 1];

        for ( int i = 1; i <= n; i++ )
            dp[i][0] = i;

        for ( int j = 1; j <= m; j++ )
            dp[0][j] = j;

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = 1; j <= m; j++ ) {
                if ( word1.charAt ( i - 1 ) == word2.charAt ( j - 1 ) ) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min ( insert, Math.min ( delete, replace ) );
                }
            }
        }

        return dp[n][m];
    }

    public int minDistanceTabulationSpaceOptimized ( String word1, String word2 ) {
        int n = word1.length ();
        int m = word2.length ();

        int[] dp = new int[m + 1];

        for ( int j = 1; j <= m; j++ )
            dp[j] = j;

        for ( int i = 1; i <= n; i++ ) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for ( int j = 1; j <= m; j++ ) {
                if ( word1.charAt ( i - 1 ) == word2.charAt ( j - 1 ) ) {
                    cur[j] = dp[j - 1];
                } else {
                    cur[j] = 1 + Math.min ( cur[j - 1], Math.min ( dp[j], dp[j - 1] ) );
                }
            }
            dp = cur;
        }

        return dp[m];
    }
}