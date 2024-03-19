package com.kingshuk.tests.DynamicProgramming;

public class LongestCommonSubsequence {

    static int longestSubSeqlength ( char[] x, char[] y, int n, int m ) {
        int[][] t = new int[ n + 1 ][ m + 1 ];

        for ( int i = 0; i <= n; i++ ) {
            for ( int j = 0; j <= m; j++ ) {
                if ( i == 0 || j == 0 ) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                    t[ i ][ j ] = 0;
                else {
                    if ( x[ i - 1 ] == y[ j - 1 ] )
                        t[ i ][ j ] = 1 + t[ i - 1 ][ j - 1 ];
                    else
                        t[ i ][ j ] = Math.max ( t[ i ][ j - 1 ], t[ i - 1 ][ j ] );
                }
            }
        }
        return t[ n ][ m ];
    }

    public static int lcsSpaceOptimized ( String s, String t ) {
        int n = s.length ();
        int m = t.length ();
        int[] dp = new int[ m + 1 ];

        for ( int i = 1; i <= n; i++ ) {
            int[] cur = new int[ m + 1 ];
            for ( int j = 1; j <= m; j++ ) {
                if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) )
                    cur[ j ] = 1 + dp[ j - 1 ];
                else
                    cur[ j ] = Math.max ( dp[ j ], cur[ j - 1 ] );
            }
            dp = cur;
        }

        return dp[ m ];
    }

    public static void main ( String[] args ) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        char[] x = s1.toCharArray ();
        char[] y = s2.toCharArray ();
        int n = x.length;
        int m = y.length;
        System.out.println ( "the longest length of substring is : " + longestSubSeqlength ( x, y, n, m ) );
    }
}
