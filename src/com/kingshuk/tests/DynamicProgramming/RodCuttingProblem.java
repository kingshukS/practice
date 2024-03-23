package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static int cutRodRecursionAndMemoization ( int[] price, int n ) {
        int[][] dp = new int[n][n + 1];
        for ( int[] dpi : dp )
            Arrays.fill ( dpi, - 1 );
        return f ( price, n - 1, n, dp );
    }

    public static int cutRodTabulationSpaceOptimized ( int[] price, int n ) {
        int[] dp = new int[n + 1];

        for ( int i = 1; i <= n; i++ )
            dp[i] = i * price[0];

        for ( int i = 1; i < n; i++ ) {
            // Need to calculate the previous columns of the current row before calculating for the current columns
            for ( int j = 1; j <= n; j++ ) {
                int notTake = dp[j];
                int take = 0;
                int rodLength = i + 1;
                if ( rodLength <= j ) {
                    take = price[i] + dp[j - rodLength];
                }

                dp[j] = Math.max ( take, notTake );
            }
        }
        return dp[n];
    }

    public static int cutRodTabulation ( int[] price, int n ) {
        int[][] dp = new int[n][n + 1];

        for ( int i = 1; i <= n; i++ )
            dp[0][i] = i * price[0];

        for ( int i = 1; i < n; i++ ) {
            for ( int j = 1; j <= n; j++ ) {
                int notTake = dp[i - 1][j];
                int take = 0;
                int rodLength = i + 1;
                if ( rodLength <= j ) {
                    take = price[i] + dp[i][j - rodLength];
                }

                dp[i][j] = Math.max ( take, notTake );
            }
        }
        return dp[n - 1][n];
    }

    private static int f ( int[] price, int index, int length, int[][] dp ) {
        if ( index == 0 ) {
            return price[0] * length;
        }
        if ( dp[index][length] != - 1 ) return dp[index][length];

        int notTake = f ( price, index - 1, length, dp );
        int take = 0;
        int rodLength = index + 1;
        if ( rodLength <= length ) {
            take = price[index] + f ( price, index, length - rodLength, dp );
        }

        return dp[index][length] = Math.max ( take, notTake );
    }

}