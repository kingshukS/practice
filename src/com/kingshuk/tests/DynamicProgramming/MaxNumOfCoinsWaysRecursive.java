package com.kingshuk.tests.DynamicProgramming;

public class MaxNumOfCoinsWaysRecursive {


    static int maxNumCoinsWaysRecursive ( int[] S, int m, int n ) {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if ( n == 0 )
            return 1;

        // If n is less than 0 then no
        // solution exists
        if ( n < 0 )
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if ( m <= 0 )
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return maxNumCoinsWaysRecursive ( S, m - 1, n ) +
                maxNumCoinsWaysRecursive ( S, m, n - S[m - 1] );
    }

    public static void main ( String[] args ) {
        int[] coins = { 1, 2, 3 };
        int n = coins.length;
        int sum = 4;
        System.out.println ( "the max number of ways are :" + maxNumCoinsWaysRecursive ( coins, n, sum ) );
    }
}
