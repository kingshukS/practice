package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static int longestStrChain ( String[] arr ) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] backtrack = new int[n];

        int max = 1;
        int maxIndex = 0;
        Arrays.sort ( arr, Comparator.comparingInt ( String::length ) );

        for ( int i = 0; i < n; i++ ) {
            dp[i] = 1;
            backtrack[i] = i;
            for ( int j = 0; j < i; j++ ) {
                if ( isAChain ( arr[i], arr[j] ) && dp[j] + 1 > dp[i] ) {
                    dp[i] = dp[j] + 1;
                    backtrack[i] = j;
                }
            }

            if ( dp[i] > max ) {
                max = dp[i];
                maxIndex = i;
            }
        }

        String[] chain = new String[max];
        int index = max - 1;

        while (backtrack[maxIndex] != maxIndex) {
            chain[index--] = arr[maxIndex];
            maxIndex = backtrack[maxIndex];
        }
        chain[index] = arr[maxIndex];
        Arrays.stream ( chain ).forEach ( x -> System.out.print ( x + " " ) );
        System.out.println ();
        return max;
    }

    private static boolean isAChain ( String s1, String s2 ) {
        if ( s1.length () != 1 + s2.length () )
            return false;

        int notMatching = 1;
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < s1.length ()) {
            if ( ptr2 < s2.length () && s1.charAt ( ptr1 ) == s2.charAt ( ptr2 ) ) {
                ptr1++;
                ptr2++;
            } else {
                ptr1++;
                notMatching--;
            }
        }
        return notMatching == 0;
    }

    public static void main ( String[] args ) {
        String[] arr = { "x", "xx", "y", "xyx" };
        System.out.println ( longestStrChain ( arr ) );
    }
}