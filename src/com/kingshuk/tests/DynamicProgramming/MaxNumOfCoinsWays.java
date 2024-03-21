package com.kingshuk.tests.DynamicProgramming;

public class MaxNumOfCoinsWays {

    public static long countWaysToMakeChange ( int[] denominations, int value ) {
        int n = denominations.length;
        return f1 ( denominations, n, value );

    }

    private static long f ( int[] denominations, int n, int value ) {
        long[][] dp = new long[n][value + 1];
        dp[0][0] = 1L;
        for ( int i = denominations[0]; i <= value; i++ ) {
            if ( i % denominations[0] == 0 )
                dp[0][i] = 1L;
        }

        for ( int i = 1; i < n; i++ ) {
            for ( int j = 0; j <= value; j++ ) {
                long notTake = dp[i - 1][j];
                long take = 0L;
                if ( denominations[i] <= j )
                    take = dp[i][j - denominations[i]];

                dp[i][j] = take + notTake;
            }
        }
        return dp[n - 1][value];
    }

    private static long f1 ( int[] denominations, int n, int value ) {

        long[] dp = new long[value + 1];

        dp[0] = 1L;
        for ( int i = denominations[0]; i <= value; i++ ) {
            if ( i % denominations[0] == 0 )
                dp[i] = 1L;
        }

        for ( int i = 1; i < n; i++ ) {
            long[] cur = new long[value + 1];
            for ( int j = 0; j <= value; j++ ) {
                long notTake = dp[j];
                long take = 0L;
                if ( denominations[i] <= j )
                    take = cur[j - denominations[i]];

                cur[j] = take + notTake;
            }
            dp = cur;
        }
        return dp[value];
    }

    // old code with 1 extra row space
    static int maxNumCoinsWays ( int[] coins, int n, int sum ) {
        int[][] t = new int[n + 1][sum + 1];
        for ( int i = 0; i <= n; i++ ) {
            for ( int j = 0; j <= sum; j++ ) {
                // for a valid sum, if there are no coins, then it can't be done, so assigning INFINITY(-1 for calculation purpose)
                if ( i == 0 ) {
                    t[i][j] = 0;
                }
                // for a sum of 0, number of ways = 1
                if ( j == 0 ) {
                    t[i][j] = 1;
                }
            }
        }

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = 1; j <= sum; j++ ) {
                if ( coins[i - 1] > j ) {
                    t[i][j] = t[i - 1][j];
                } else
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
            }
        }

        return t[n][sum];
    }

    public static void main ( String[] args ) {
        int[] coins = { 1, 2, 3 };
        int n = coins.length;
        int sum = 4;
        //System.out.println("the max number of ways are :" + maxNumCoinsWays(coins, n, sum));

        System.out.println ( "the max number of ways are :" + countWaysToMakeChange ( coins, sum ) );
    }
}
