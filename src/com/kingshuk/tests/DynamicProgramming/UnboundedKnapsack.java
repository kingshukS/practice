package com.kingshuk.tests.DynamicProgramming;

// Unbounded Knapsack/ Rod-cutting problem
public class UnboundedKnapsack {

    // old code syntax
    static int knapsack01 ( int[] wt, int[] value, int W, int n ) {
        int[][] t = new int[ n + 1 ][ W + 1 ];
        int i, j;
        for ( i = 0; i <= n; i++ ) {
            for ( j = 0; j <= W; j++ ) {
                if ( i == 0 ) {
                    t[ i ][ j ] = 0;
                }
                if ( j == 0 ) {
                    t[ i ][ j ] = 0;
                }
            }
        }

        for ( i = 1; i <= n; i++ ) {
            for ( j = 1; j <= W; j++ ) {
                if ( wt[ i - 1 ] > j ) {
                    t[ i ][ j ] = t[ i - 1 ][ j ];
                } else {
                    t[ i ][ j ] = Math.max ( value[ i - 1 ] + t[ i ][ j - wt[ i - 1 ] ], t[ i - 1 ][ j ] );
                }
            }
        }
        return t[ n ][ W ];
    }

    public static int unboundedKnapsackRecursion ( int index, int w, int[] profit, int[] weight ) {
        if ( index == 0 )
            return ( (int) ( w / weight[ 0 ] ) ) * profit[ 0 ];
        int notTake = unboundedKnapsackRecursion ( index - 1, w, profit, weight );
        int take = 0;
        if ( weight[ index ] <= w )
            take = profit[ index ] + unboundedKnapsackRecursion ( index, w - weight[ index ], profit, weight );
        return Math.max ( take, notTake );
    }

    public static int unboundedKnapsackTabulation ( int n, int w, int[] profit, int[] weight ) {
        int[][] dp = new int[ n ][ w + 1 ];

        for ( int wt = weight[ 0 ]; wt <= w; wt++ )
            dp[ 0 ][ wt ] = ( (int) ( wt / weight[ 0 ] ) ) * profit[ 0 ];

        for ( int idx = 1; idx < n; idx++ ) {
            for ( int wt = 1; wt <= w; wt++ ) {
                int notTake = dp[ idx - 1 ][ wt ];
                int take = 0;
                if ( weight[ idx ] <= wt )
                    take = profit[ idx ] + dp[ idx ][ wt - weight[ idx ] ];
                dp[ idx ][ wt ] = Math.max ( take, notTake );
            }
        }
        return dp[ n - 1 ][ w ];
    }

    private static int unboundedKnapsackUtil ( int n, int w, int[] profit, int[] weight ) {
        int[] dp = new int[ w + 1 ];
        for ( int i = 0; i <= w; i++ ) {
            int num = i / weight[ 0 ];
            dp[ i ] = num * profit[ 0 ];
        }

        for ( int i = 1; i < n; i++ ) {
            // Need to calculate the previous columns of the current row before calculating for the current columns
            for ( int j = 1; j <= w; j++ ) {
                int notTake = dp[ j ];
                int take = 0;
                if ( weight[ i ] <= j ) {
                    take = profit[ i ] + dp[ j - weight[ i ] ];
                }
                dp[ j ] = Math.max ( take, notTake );
            }
        }
        return dp[ w ];
    }

    public static void main ( String[] args ) {
        int[] wt = { 10, 20, 30 };
        int[] profit = { 60, 100, 120 };
        int W = 50;
        int n = profit.length;
        System.out.print ( unboundedKnapsackTabulation ( n, W, profit, wt ) );
    }
}
