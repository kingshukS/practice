package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class SubsetSum {

    static boolean subSetProb ( int n, int k, int[] arr ) {
        boolean[][] dp = new boolean[n][k + 1];

        //base case 1: if(k == 0) return true;
        for ( int i = 0; i < n; i++ ) {
            dp[i][0] = true;
        }

        //base case 2: if(index == 0) return arr[0] == k; => possible only if the element @ index 0 is a part of the subsequence
        if ( arr[0] <= k )
            dp[0][arr[0]] = true;

        for ( int index = 1; index < n; index++ ) {
            for ( int target = 1; target <= k; target++ ) {
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if ( arr[index] <= target )
                    take = dp[index - 1][target - arr[index]];
                dp[index][target] = notTake || take;
            }
        }
        return dp[n - 1][k];
    }

    static boolean subSetProbSpaceOptimized ( int n, int k, int[] arr ) {
        boolean[] prev = new boolean[k + 1];

        //base case 1: if(k == 0) return true;
        prev[0] = true;

        /*
        base case 2: if(index == 0) return arr[0] == k; this is valid only for the first row (for index = 0),
        not propagating this base case for subsequent rows (created as boolean[] cur = new boolean[k+1])
        */
        if ( arr[0] <= k )
            prev[arr[0]] = true;

        for ( int index = 1; index < n; index++ ) {
            boolean[] cur = new boolean[k + 1];
            cur[0] = true;
            for ( int target = 1; target <= k; target++ ) {
                boolean notTake = prev[target];
                boolean take = false;
                if ( arr[index] <= target )
                    take = prev[target - arr[index]];
                cur[target] = notTake || take;
            }
            prev = cur;
        }
        return prev[k];
    }

    static boolean subSetProbSpaceOptimized2 ( int n, int k, int[] arr ) {
        boolean[] prev = new boolean[k + 1];

        //base case 1: if(k == 0) return true;
        prev[0] = true;

        /*
         base case 2: if(index == 0) return arr[0] == k; this is valid only for the first row (for index = 0),
         not propagating this base case for subsequent rows (created as boolean[] cur = new boolean[k+1])
         */
        if ( arr[0] <= k )
            prev[arr[0]] = true;

        for ( int index = 1; index < n; index++ ) {
            /*
             Reversing this loop, so that we can use only one array.
             This works because we always use current cell or a cell to the left to determine the current value.
             Once computed, we modify it and move to the left. The computation never depends on a cell value at the right,
             this won't affect the result if we reverse the loop. (<- is used instead of ->)
             */
            for ( int target = k; target >= 1; target-- ) {
                boolean notTake = prev[target];
                boolean take = false;
                if ( arr[index] <= target )
                    take = prev[target - arr[index]];
                prev[target] = notTake || take;
            }
        }
        return prev[k];
    }

    public static boolean subsetSumToK ( int n, int k, int[] arr ) {
        int[][] dp = new int[n][k + 1];
        for ( int[] x : dp )
            Arrays.fill ( x, - 1 );
        return subset ( arr, n - 1, k, dp );
    }

    private static boolean subset ( int[] arr, int index, int k, int[][] dp ) {
        //base case 1
        if ( k == 0 )
            return true;
        //base case 2
        if ( index == 0 )
            return arr[0] == k;
        if ( dp[index][k] != - 1 ) return dp[index][k] == 1;
        boolean notTake = subset ( arr, index - 1, k, dp );
        boolean take = false;
        if ( arr[index] <= k )
            take = subset ( arr, index - 1, k - arr[index], dp );
        boolean res = notTake || take;
        dp[index][k] = res ? 1 : 0;
        return res;
    }

    public static void main ( String[] args ) {
        int[] arr = { 300, 34, 4, 12, 5, 2 };
        int sum = 46;
        int n = arr.length;
        boolean ans = subSetProb ( 6, sum, arr );//subSetProb(arr, sum, n);
        if ( ans ) {
            System.out.println ( "Subset is possible " );
        } else {
            System.out.println ( "Subset is not possible " );
        }
    }

}
