package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump ( int n, int[] heights ) {

        int[] dp = new int[n];
        Arrays.fill ( dp, - 1 );
        System.out.println ( frogJumpUtil2 ( n - 1, heights, dp ) );
        System.out.println ( frogJumpUtil ( n - 1, heights, dp ) );
        System.out.println ( frogJumpUtil3 ( n - 1, heights ) );
        return frogJumpUtilWithKJumps ( n - 1, heights, dp, 2 );
    }

    // Memoization
    public static int frogJumpUtil ( int index, int[] heights, int[] dp ) {

        if ( index == 0 )
            return 0;

        int x = dp[index - 1] != - 1 ? dp[index - 1] : frogJumpUtil ( index - 1, heights, dp );
        int step1 = x + Math.abs ( heights[index] - heights[index - 1] );
        int step2 = Integer.MAX_VALUE;
        if ( index >= 2 ) {
            int y = ( dp[index - 2] != - 1 ? dp[index - 2] : frogJumpUtil ( index - 2, heights, dp ) );
            step2 = y + Math.abs ( heights[index] - heights[index - 2] );
        }
        return dp[index] = Math.min ( step1, step2 );
    }

    // Tabulation
    public static int frogJumpUtil2 ( int index, int[] heights, int[] dp ) {

        for ( int i = 0; i <= index; i++ ) {
            if ( i == 0 ) {
                dp[i] = 0;
            } else if ( i == 1 ) {
                dp[i] = Math.abs ( heights[1] - heights[0] );
            } else {
                int step1 = Math.abs ( heights[i] - heights[i - 1] ) + dp[i - 1];
                int step2 = Math.abs ( heights[i] - heights[i - 2] ) + dp[i - 2];
                dp[i] = Math.min ( step1, step2 );
            }
        }
        return dp[index];
    }

    // With K jumps allowed
    public static int frogJumpUtilWithKJumps ( int n, int[] heights, int[] dp, int k ) {

        for ( int i = 0; i <= n; i++ ) {
            if ( i == 0 ) {
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for ( int j = 1; j <= k && i - j >= 0; j++ ) {
                    min = Math.min ( min, Math.abs ( heights[i] - heights[i - j] ) + dp[i - j] );
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    // Tabulation Optimized
    public static int frogJumpUtil3 ( int n, int[] heights ) {
        int prev2 = 0;
        int prev = Math.abs ( heights[1] - heights[0] );
        for ( int i = 2; i <= n; i++ ) {
            int step1 = Math.abs ( heights[i] - heights[i - 1] ) + prev;
            int step2 = Math.abs ( heights[i] - heights[i - 2] ) + prev2;
            int ans = Math.min ( step1, step2 );
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    public static void main ( String[] args ) {
        int[] heights = new int[]{ 7, 5, 5, 8, 4, 9, 1, 1, 10 };
        System.out.println ( frogJump ( 9, heights ) );
    }

}