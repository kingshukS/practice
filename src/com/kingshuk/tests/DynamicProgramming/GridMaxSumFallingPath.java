package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class GridMaxSumFallingPath {
    public static int getMaxPathSum ( int[][] matrix ) {
        int n = matrix.length;
        int m = matrix[n - 1].length;

        int[][] dp = new int[n][m];

        int max = - (int) 1e9;
        for ( int i = 0; i < m; i++ ) {
            initializeDP ( dp, n, m );
            int temp = findMax ( n - 1, i, matrix, m, dp );
            max = Math.max ( temp, max );
        }

        return max;
    }

    public static int getMaxPathSumTabulation ( int[][] matrix ) {
        int n = matrix.length;
        int m = matrix[n - 1].length;

        int[][] dp = new int[n][m];

        // first row
        System.arraycopy ( matrix[0], 0, dp[0], 0, m );

        for ( int i = 1; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                int max = matrix[i][j] + dp[i - 1][j];
                if ( j != 0 )
                    max = Math.max ( max, matrix[i][j] + dp[i - 1][j - 1] );
                if ( j != m - 1 )
                    max = Math.max ( max, matrix[i][j] + dp[i - 1][j + 1] );
                dp[i][j] = max;
            }
        }
        int ans = Integer.MIN_VALUE;
        for ( int j = 0; j < m; j++ ) {
            ans = Math.max ( ans, dp[n - 1][j] );
        }
        return ans;
    }

    public static int getMaxPathSumTabulationSpaceOptimized ( int[][] matrix ) {
        int n = matrix.length;
        int m = matrix[n - 1].length;

        int[] dp = new int[m];

        // first row
        System.arraycopy ( matrix[0], 0, dp, 0, m );

        for ( int i = 1; i < n; i++ ) {
            int[] temp = new int[m];
            for ( int j = 0; j < m; j++ ) {
                int max = matrix[i][j] + dp[j];
                if ( j != 0 )
                    max = Math.max ( max, matrix[i][j] + dp[j - 1] );
                if ( j != m - 1 )
                    max = Math.max ( max, matrix[i][j] + dp[j + 1] );
                temp[j] = max;
            }
            dp = temp;
        }
        int ans = Integer.MIN_VALUE;
        for ( int j = 0; j < m; j++ ) {
            ans = Math.max ( ans, dp[j] );
        }
        return ans;
    }

    public static void initializeDP ( int[][] dp, int n, int m ) {
        for ( int i = 0; i < n; i++ ) {
            Arrays.fill ( dp[i], - 1 );
        }
    }

    public static int findMax ( int row, int col, int[][] matrix, int m, int[][] dp ) {
        if ( col < 0 || col >= m )
            return - (int) 1e9;

        if ( row == 0 )
            return matrix[row][col];

        if ( dp[row][col] != - 1 ) return dp[row][col];

        int up = matrix[row][col] + findMax ( row - 1, col, matrix, m, dp );
        int ld = matrix[row][col] + findMax ( row - 1, col - 1, matrix, m, dp );
        int rd = matrix[row][col] + findMax ( row - 1, col + 1, matrix, m, dp );

        return dp[row][col] = Math.max ( up, Math.max ( ld, rd ) );
    }
}
