package com.kingshuk.tests.DynamicProgramming;

public class MinimumNumberOfInsertionDeletionToConvertAToB {
    public static void main ( String[] args ) {
        String s1 = "heap";
        String s2 = "pea";
        canYouMake ( s1, s2 );
    }

    private static void canYouMake ( String s1, String s2 ) {
        int m = s1.length ();
        int n = s2.length ();
        int[] t = new int[n + 1];
        for ( int i = 0; i <= m; i++ ) {
            int[] cur = new int[n + 1];
            for ( int j = 0; j <= n; j++ ) {
                if ( i == 0 || j == 0 ) {
                    cur[j] = 0;
                } else if ( s1.charAt ( i - 1 ) == s2.charAt ( j - 1 ) ) {
                    cur[j] = 1 + t[j - 1];
                } else {
                    cur[j] = Math.max ( cur[j - 1], t[j] );
                }
            }
            t = cur;
        }
        System.out.println ( "Number of deletion:" + ( m - t[n] ) );
        System.out.println ( "Number of insertion:" + ( n - t[n] ) );
    }
}
