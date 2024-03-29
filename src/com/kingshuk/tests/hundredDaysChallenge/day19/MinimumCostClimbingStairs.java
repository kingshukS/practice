package com.kingshuk.tests.hundredDaysChallenge.day19;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinimumCostClimbingStairs {
    public int minCostClimbingStairs ( int[] cost ) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if ( n == 2 ) return Math.min ( first, second );
        for ( int i = 2; i < n; i++ ) {
            int curr = cost[i] + Math.min ( first, second );
            first = second;
            second = curr;
        }
        return Math.min ( first, second );
    }
}
