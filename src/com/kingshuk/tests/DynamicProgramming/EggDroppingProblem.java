package com.kingshuk.tests.DynamicProgramming;

public class EggDroppingProblem {
    static int[][] t;

    public static void main ( String[] args ) {
        int n = 2, k = 10;
        System.out.print ( "Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDropUtil ( n, k ) );
    }

    private static int eggDropTabulation ( int e, int f ) {
        t = new int[e + 1][f + 1];

        // base case initialization
        for ( int i = 0; i <= e; i++ ) {
            for ( int j = 0; j <= f; j++ ) {
                if ( i == 1 )
                    t[i][j] = j;
                if ( j == 0 || j == 1 )
                    t[i][j] = j;
            }
        }
        for ( int i = 2; i <= e; i++ ) {
            for ( int j = 2; j <= f; j++ ) {
                t[i][j] = Integer.MAX_VALUE;
                for ( int k = 1; k <= j; k++ ) {
                    int temp1 = t[i - 1][k - 1];
                    int temp2 = t[i][j - k];
                    int temp = 1 + Math.max ( temp1, temp2 );
                    t[i][j] = Math.min ( temp, t[i][j] );
                }
            }
        }
        return t[e][f];
    }

    private static int eggDropUtil ( int e, int f ) {
        t = new int[e + 1][f + 1];
        for ( int i = 0; i <= e; i++ ) {
            for ( int j = 0; j <= f; j++ ) {
                t[i][j] = - 1;
            }
        }
        return eggDrop ( e, f );
    }

    private static int eggDrop ( int e, int f ) {
        if ( e == 1 )
            return f;
        if ( f == 0 || f == 1 )
            return f;
        if ( t[e][f] != - 1 )
            return t[e][f];
        int min = Integer.MAX_VALUE;
        for ( int k = 1; k <= f; k++ ) {
            int eggBreak = t[e - 1][k - 1] != - 1 ? t[e - 1][k - 1] : eggDrop ( e - 1, k - 1 );
            int eggNotBreak = t[e][f - k] != - 1 ? t[e][f - k] : eggDrop ( e, f - k );
            int temp = 1 + Math.max ( eggBreak, eggNotBreak );
            min = Math.min ( temp, min );
        }
        return t[e][f] = min;
    }
}
