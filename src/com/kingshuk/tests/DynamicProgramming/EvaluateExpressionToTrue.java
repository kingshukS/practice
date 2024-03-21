package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class EvaluateExpressionToTrue {

    static int[][][] dp;

    public static void main ( String[] args ) {
        String expr = "T^F&T";
        int countWays = findWays ( expr );
        System.out.print ( "Boolean parenthesize : count of ways = " + countWays );
    }

    private static int findWays ( String expr ) {
        int n = expr.length ();
        int i = 0;
        int j = n - 1;
        dp = new int[n][n][2];
        for ( int[][] row : dp )
            for ( int[] col : row )
                Arrays.fill ( col, - 1 );
        return findWays ( expr, i, j, 1 );
    }

    private static int findWays ( String expr, int i, int j, int isTrue ) {
        if ( i > j )
            return 0;
        if ( i == j ) {
            if ( isTrue == 1 ) {
                if ( expr.charAt ( i ) == 'T' )
                    return 1;
                else
                    return 0;
            } else {
                if ( expr.charAt ( i ) == 'F' )
                    return 1;
                else
                    return 0;
            }
        }

        if ( dp[i][j][isTrue] != - 1 ) return dp[i][j][isTrue];

        int ans = 0;
        for ( int k = i + 1; k < j; k = k + 2 ) {
            int lT = dp[i][k - 1][1] != - 1 ? dp[i][k - 1][1] : findWays ( expr, i, k - 1, 1 );
            int lF = dp[i][k - 1][0] != - 1 ? dp[i][k - 1][0] : findWays ( expr, i, k - 1, 0 );
            int rT = dp[k + 1][j][1] != - 1 ? dp[k + 1][j][1] : findWays ( expr, k + 1, j, 1 );
            int rF = dp[k + 1][j][0] != - 1 ? dp[k + 1][j][0] : findWays ( expr, k + 1, j, 0 );

            if ( expr.charAt ( k ) == '&' ) {
                if ( isTrue == 1 ) {
                    ans += lT * rT;
                } else {
                    ans += lF * rF + lF * rT + lT * rF;
                }
            } else if ( expr.charAt ( k ) == '|' ) {
                if ( isTrue == 1 ) {
                    ans += lT * rT + lF * rT + lT * rF;
                } else {
                    ans += lF * rF;
                }
            } else {
                if ( isTrue == 1 ) {
                    ans += lT * rF + lF * rT;
                } else {
                    ans += lF * rF + lT * rT;
                }
            }
        }
        return dp[i][j][isTrue] = ans;
    }
}
