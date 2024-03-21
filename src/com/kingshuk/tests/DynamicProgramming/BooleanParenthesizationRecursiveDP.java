package com.kingshuk.tests.DynamicProgramming;

public class BooleanParenthesizationRecursiveDP {

    static int[][][] dp;

    public static void main ( String[] args ) {
        String str = "T|T&F^T";
        int n = str.length ();
		/* There are 4 ways
		 ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
		 (T|((T&F)^T))*/
        System.out.println ( "Total no of ways:" + countWays ( n, str ) );
    }

    private static int countWays ( int n, String str ) {
        dp = new int[n][n][2];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                dp[i][j][0] = - 1;
                dp[i][j][1] = - 1;
            }
        }
        return countRecursiveParenthesization ( str, 0, n - 1, 1 );
    }

    private static int countRecursiveParenthesization ( String str, int i, int j, int isTrue ) {
        if ( i > j )
            return 0;
        if ( i == j ) {
            if ( isTrue == 1 )
                return str.charAt ( i ) == 'T' ? 1 : 0;
            else
                return str.charAt ( i ) == 'F' ? 1 : 0;
        }
        if ( dp[i][j][isTrue] != - 1 )
            return dp[i][j][isTrue];

        int leftTrue = 0, leftFalse = 0, rightTrue = 0, rightFalse = 0;
        int tempAns = 0;
        for ( int k = i + 1; k <= j - 1; k = k + 2 ) {

            if ( dp[i][k - 1][1] != - 1 )
                leftTrue = dp[i][k - 1][1];
            else
                leftTrue = countRecursiveParenthesization ( str, i, k - 1, 1 );

            if ( dp[i][k - 1][0] != - 1 )
                leftFalse = dp[i][k - 1][0];
            else
                leftFalse = countRecursiveParenthesization ( str, i, k - 1, 0 );

            if ( dp[k + 1][j][1] != - 1 )
                rightTrue = dp[k + 1][j][1];
            else
                rightTrue = countRecursiveParenthesization ( str, k + 1, j, 1 );

            if ( dp[k + 1][j][0] != - 1 )
                rightFalse = dp[k + 1][j][0];
            else
                rightFalse = countRecursiveParenthesization ( str, k + 1, j, 0 );

            if ( str.charAt ( k ) == '&' ) {
                if ( isTrue == 1 ) {
                    tempAns += leftTrue * rightTrue;
                } else {
                    tempAns += leftTrue * rightFalse + rightTrue * leftFalse + leftFalse * rightFalse;
                }
            } else if ( str.charAt ( k ) == '|' ) {
                if ( isTrue == 1 ) {
                    tempAns += leftTrue * rightFalse + rightTrue * leftFalse + leftTrue * rightTrue;
                } else {
                    tempAns += leftFalse * rightFalse;
                }
            } else if ( str.charAt ( k ) == '^' ) {
                if ( isTrue == 1 ) {
                    tempAns += leftTrue * rightFalse + rightTrue * leftFalse;
                } else {
                    tempAns += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }
        return dp[i][j][isTrue] = tempAns;
    }
}
