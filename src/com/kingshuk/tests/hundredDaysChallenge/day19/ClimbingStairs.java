package com.kingshuk.tests.hundredDaysChallenge.day19;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
    }
    public int climbStairs(int n) {
        return ways(0, 1, n) + ways(0, 2, n);
    }

    private int ways(int base, int add, int n) {
        base = base + add;
        if(base == n)
            return 1;
        if(base > n)
            return 0;
        return ways(base, 1, n)+ways(base, 2, n);
    }

    public int climbStairsBestFibonacci(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before_ways = 2;
        int two_steps_before_ways = 1;
        int all_ways = 0;

        for(int i=3; i<=n; i++){
            all_ways = one_step_before_ways + two_steps_before_ways;
            two_steps_before_ways = one_step_before_ways;
            one_step_before_ways = all_ways;
        }
        return all_ways;
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
