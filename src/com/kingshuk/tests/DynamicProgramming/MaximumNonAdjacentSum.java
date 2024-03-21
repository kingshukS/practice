package com.kingshuk.tests.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumNonAdjacentSum {
    public static int maximumNonAdjacentSum ( ArrayList<Integer> nums ) {
        int n = nums.size ();
        int[] dp = new int[n];
        Arrays.fill ( dp, - 1 );
        return maximumNonAdjacentSum ( nums, n - 1, dp );
    }

    // Memoization
    private static int maximumNonAdjacentSum ( ArrayList<Integer> nums, int index, int[] dp ) {
        if ( index == 0 ) return nums.get ( index );
        if ( index < 0 ) return 0;

        if ( dp[index] != - 1 ) return dp[index];
        int pick = nums.get ( index ) + maximumNonAdjacentSum ( nums, index - 2, dp );
        int notPick = maximumNonAdjacentSum ( nums, index - 1, dp );

        return dp[index] = Math.max ( pick, notPick );
    }

    // Tabulation
    private static int maximumNonAdjacentSumTabulation ( ArrayList<Integer> nums ) {
        int n = nums.size ();
        int[] dp = new int[n];
        dp[0] = nums.get ( 0 );

        if ( n == 1 )
            return dp[0];

        // dp[1] = Math.max(nums.get(0), nums.get(1));
        for ( int i = 1; i < n; i++ ) {
            int pick = nums.get ( i );
            if ( i > 1 ) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max ( pick, notPick );
        }
        return dp[n - 1];
    }

    // Tabulation Space Optimized
    public static int maximumNonAdjacentSumTabulationSO ( ArrayList<Integer> nums ) {
        int n = nums.size ();
        int prev = nums.get ( 0 );
        int prev2 = 0;
        for ( int i = 1; i < n; i++ ) {
            int pick = nums.get ( i );
            if ( i > 1 ) pick += prev2;
            int notPick = prev;
            int curI = Math.max ( pick, notPick );
            prev2 = prev;
            prev = curI;
        }
        return prev;
    }

    public static void main ( String[] args ) {
        ArrayList<Integer> list = new ArrayList<> ();
        list.add ( 2 );
        list.add ( 1 );
        list.add ( 4 );
        //list.add(9);
        System.out.println ( maximumNonAdjacentSumTabulation ( list ) );
        System.out.println ( maximumNonAdjacentSum ( list ) );
        System.out.println ( maximumNonAdjacentSumTabulationSO ( list ) );
    }
}