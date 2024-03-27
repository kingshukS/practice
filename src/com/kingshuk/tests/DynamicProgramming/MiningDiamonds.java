package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Bursting Balloons
public class MiningDiamonds {
    public static int maxCoinsTabulation ( int[] a ) {

        List<Integer> mines = Arrays.stream ( a ).boxed ().collect ( Collectors.toList () );
        int n = a.length;
        mines.add ( 0, 1 );
        mines.add ( 1 );

        int[][] dp = new int[n + 2][n + 2];

        for ( int i = n; i >= 1; i-- ) {
            for ( int j = i; j <= n; j++ ) {
                int maxi = Integer.MIN_VALUE;
                for ( int k = i; k <= j; k++ ) {
                    maxi = Math.max ( maxi, dp[i][k - 1] + dp[k + 1][j] + mines.get ( i - 1 ) * mines.get ( j + 1 ) * mines.get ( k ) );
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static int maxCoinsMemoization ( int[] a ) {
        List<Integer> list = Arrays.stream ( a ).boxed ().collect ( Collectors.toList () );
        int n = a.length;
        list.add ( 0, 1 );
        list.add ( 1 );

        int[][] dp = new int[n + 1][n + 1];

        for ( int[] row : dp ) {
            Arrays.fill ( row, - 1 );
        }

        return f ( 1, n, list, dp );
    }

    private static int f ( int i, int j, List<Integer> mines, int[][] dp ) {
        if ( i > j ) {
            return 0;
        }

        if ( dp[i][j] != - 1 )
            return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for ( int ind = i; ind <= j; ind++ ) {
            int ans = mines.get ( i - 1 ) * mines.get ( j + 1 ) * mines.get ( ind ) +
                    f ( i, ind - 1, mines, dp ) +
                    f ( ind + 1, j, mines, dp );

            maxi = Math.max ( maxi, ans );
        }

        return dp[i][j] = maxi;
    }

}