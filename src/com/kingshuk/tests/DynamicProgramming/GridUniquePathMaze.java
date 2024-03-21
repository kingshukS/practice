package com.kingshuk.tests.DynamicProgramming;

import java.util.ArrayList;

public class GridUniquePathMaze {
    private static final int mod = (int) ( 1e9 + 7 );

    private static int mazeObstaclesUtil ( int i, int j, ArrayList<ArrayList<Integer>> mat ) {
        if ( i >= 0 && j >= 0 && mat.get ( i ).get ( j ) == - 1 )
            return 0;
        if ( i == 0 && j == 0 )
            return 1;
        if ( i < 0 || j < 0 )
            return 0;

        int up = mazeObstaclesUtil ( i - 1, j, mat );
        int left = mazeObstaclesUtil ( i, j - 1, mat );

        return up + left;
    }

    public static int mazeObstaclesMemoization ( int m, int n, ArrayList<ArrayList<Integer>> mat ) {
        int[][] dp = new int[m][n];
        for ( int i = 0; i < m; i++ )
            for ( int j = 0; j < n; j++ )
                dp[i][j] = - 1;
        return mazeObstaclesUtil ( m - 1, n - 1, dp, mat );
    }

    private static int mazeObstaclesUtil ( int i, int j, int[][] dp, ArrayList<ArrayList<Integer>> mat ) {
        if ( i >= 0 && j >= 0 && mat.get ( i ).get ( j ) == - 1 )
            return 0;
        if ( i == 0 && j == 0 )
            return 1;
        if ( i < 0 || j < 0 )
            return 0;

        if ( dp[i][j] != - 1 ) return dp[i][j];
        int up = mazeObstaclesUtil ( i - 1, j, dp, mat );
        int left = mazeObstaclesUtil ( i, j - 1, dp, mat );

        return dp[i][j] = ( up + left ) % mod;
    }

    // Tabulation
    public static int mazeObstaclesTabulation ( int n, int m, ArrayList<ArrayList<Integer>> mat ) {
        int[][] dp = new int[n][m];

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( i >= 0 && j >= 0 && mat.get ( i ).get ( j ) == - 1 ) dp[i][j] = 0;
                else if ( i == 0 && j == 0 ) dp[i][j] = 1;
                else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = ( up + left ) % mod;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // Space Optimized
    public static int mazeObstaclesSO ( int n, int m, ArrayList<ArrayList<Integer>> mat ) {
        int[] prev = new int[m];

        for ( int i = 0; i < n; i++ ) {
            int[] cur = new int[m];
            for ( int j = 0; j < m; j++ ) {
                if ( i >= 0 && j >= 0 && mat.get ( i ).get ( j ) == - 1 ) cur[j] = 0;
                else if ( i == 0 && j == 0 ) cur[j] = 1;
                else {
                    int up = i > 0 ? prev[j] : 0;
                    int left = j > 0 ? cur[j - 1] : 0;

                    cur[j] = ( up + left ) % mod;
                }
            }
            prev = cur;
        }
        return prev[m - 1];
    }
}