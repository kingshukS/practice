package com.kingshuk.tests.DynamicProgramming;

public class ShortestCommonSuperSequence {

    static int shortestCommonSuperSequence ( char[] s1, char[] s2, int n, int m ) {
        int[] t = new int[m + 1];
        int totalLen = n + m;

        for ( int i = 1; i <= n; i++ ) {
            int[] cur = new int[m + 1];
            for ( int j = 1; j <= m; j++ ) {
                if ( s1[i - 1] == s2[j - 1] ) {
                    cur[j] = 1 + t[j - 1];
                } else
                    cur[j] = Math.max ( t[j], cur[j - 1] );
            }
            t = cur;
        }

        return totalLen - t[m];
    }

    public static void main ( String[] args ) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        char[] a1 = a.toCharArray ();
        char[] b1 = b.toCharArray ();
        int n = a.length ();
        int m = b.length ();
        System.out.println ( "the shortest common super sequence is : " + shortestCommonSuperSequence ( a1, b1, n, m ) );
    }
}
