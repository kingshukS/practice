package com.kingshuk.tests.DynamicProgramming;

public class LongestPalindromicSubsequence {
    public static void main ( String[] args ) {
        String s = "abacdfgdcaba";
        System.out.println ( "Longest Palindromic Subsequence length: " + findLongestPalindromicSubsequence ( s ) );
    }

    private static int findLongestPalindromicSubsequence ( String s ) {
        int n = s.length ();
        int[][] t = new int[n + 1][n + 1];
        String s1 = new StringBuilder ( s ).reverse ().toString ();
        for ( int i = 0; i <= n; i++ ) {
            for ( int j = 0; j <= n; j++ ) {
                if ( i == 0 || j == 0 ) {
                    t[i][j] = 0;
                } else if ( s.charAt ( i - 1 ) == s1.charAt ( j - 1 ) ) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max ( t[i][j - 1], t[i - 1][j] );
                }
            }
        }
        return t[n][n];
    }
}
