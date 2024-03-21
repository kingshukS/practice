package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {
    public static void main ( String[] args ) {
        long startTime = System.nanoTime ();
        String str = "ababbbabbababa";
        System.out.println ( "Min cuts needed for "
                + "Palindrome Partitioning is " + palindromePartitioning ( str ) );
        long endTime = System.nanoTime ();
        System.out.println ( "Duration:" + ( endTime - startTime ) );
    }

    public static int partition ( String s ) {
        boolean[][] dp = new boolean[s.length ()][s.length ()];
        for ( int i = 0; i < s.length (); i++ ) {
            for ( int j = 0; j <= i; j++ ) {
                if ( s.charAt ( i ) == s.charAt ( j ) && ( i - j <= 2 || dp[j + 1][i - 1] ) )
                    dp[j][i] = true;
            }
        }
        return palindromicPartitionsRecursive ( 0, s.length () - 1, dp );
    }

    private static int palindromicPartitionsRecursive ( int i, int j, boolean[][] dp ) {
        if ( i >= j || dp[i][j] )
            return 0;
        int min = Integer.MAX_VALUE;
        for ( int k = i; k < j; k++ ) {
            int temp = dp[i][k] ? 0 : palindromicPartitionsRecursive ( i, k, dp );
            temp += dp[k + 1][j] ? 0 : palindromicPartitionsRecursive ( k + 1, j, dp );
            min = Math.min ( temp + 1, min );
        }
        return min;
    }

    public static int palindromePartitioning ( String str ) {
        int n = str.length ();
        int[] dp = new int[n];
        Arrays.fill ( dp, - 1 );
        return f ( 0, n, str, dp ) - 1;
    }

    private static int f ( int ind, int n, String str, int[] dp ) {
        if ( ind == n )
            return 0;
        if ( dp[ind] != - 1 ) return dp[ind];

        int min = Integer.MAX_VALUE;
        for ( int p = ind; p < n; p++ ) {
            if ( isPalindrome ( str, ind, p ) ) {
                int cost = 1 + f ( p + 1, n, str, dp );
                min = Math.min ( cost, min );
            }
        }
        return dp[ind] = min;
    }

    private static boolean isPalindrome ( String s, int l, int r ) {
        if ( l >= r )
            return true;
        if ( s.charAt ( l ) != s.charAt ( r ) )
            return false;
        return isPalindrome ( s, l + 1, r - 1 );
    }

    public static int palindromePartitioningTabulation2 ( String str ) {
        int n = str.length ();
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for ( int ind = n - 1; ind >= 0; ind-- ) {
            int min = Integer.MAX_VALUE;
            for ( int p = ind; p < n; p++ ) {
                if ( isPalindrome ( str, ind, p ) ) {
                    int cost = 1 + dp[p + 1];
                    min = Math.min ( cost, min );
                }
            }
            dp[ind] = min;
        }
        return dp[0] - 1;
    }

    private static int palindromePartitioningTabulation ( String str, int l, int r, int n ) {
        int[][] t = new int[n][n];
        boolean[][] p = new boolean[n][n];
        for ( int i = 0; i < n; i++ ) {
            t[i][i] = 0;
            p[i][i] = true;
        }

        for ( int L = 2; L <= n; L++ ) {
            for ( int i = 0; i <= n - L; i++ ) {
                int j = i + L - 1;
                if ( j == n )
                    continue;
                boolean charEquals = str.charAt ( i ) == str.charAt ( j );
                if ( L == 2 )
                    p[i][j] = charEquals;
                else
                    p[i][j] = ( charEquals && p[i + 1][j - 1] );
                if ( p[i][j] )
                    t[i][j] = 0;
                else {
                    t[i][j] = Integer.MAX_VALUE;
                    for ( int k = i; k < j; k++ ) {
                        int temp = t[i][k] + t[k + 1][j] + 1;
                        t[i][j] = Math.min ( t[i][j], temp );
                    }
                }
            }
        }
        return t[0][n - 1];
    }
}
