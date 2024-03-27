package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestDivisibleSet {
    public static List<Integer> divisibleSet ( int[] arr ) {
        int n = arr.length;
        Arrays.sort ( arr );
        int[] dp = new int[n];
        int[] backtrack = new int[n];

        int max = 0, maxIndex = 0;
        for ( int i = 0; i < n; i++ ) {
            dp[i] = 1;
            backtrack[i] = i;
            for ( int j = 0; j < i; j++ ) {
                if ( arr[i] % arr[j] == 0 && dp[j] + 1 > dp[i] ) {
                    dp[i] = dp[j] + 1;
                    backtrack[i] = j;
                }
            }
            if ( dp[i] > max ) {
                max = dp[i];
                maxIndex = i;
            }
        }

        int[] lis = new int[max];
        int index = max - 1;
        while (backtrack[maxIndex] != maxIndex) {
            lis[index--] = arr[maxIndex];
            maxIndex = backtrack[maxIndex];
        }
        lis[index] = arr[maxIndex];
        return Arrays.stream ( lis ).boxed ().collect ( Collectors.toList () );
    }

    public static void main ( String[] args ) {
        int[] arr = { 1, 8, 7, 16, 4 };
        System.out.println ( divisibleSet ( arr ) );
    }
}