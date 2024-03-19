package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class MinNumOfCoins {


    static int minNumCoins(int[] coins, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= sum; k++) {
                // for a valid sum, if there are no coins, then it can't be done, so assigning INFINITY(-1 for calculation purpose)
                if (i == 0) {
                    t[0][k] = Integer.MAX_VALUE - 1;
                }
                // for a sum of 0, min number of coins = 0
                if (k == 0) {
                    t[i][0] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= sum; k++) {
                if (coins[i - 1] > k) {
                    t[i][k] = t[i - 1][k];
                } else
                    t[i][k] = Math.min(1 + t[i][k - coins[i - 1]],
                            t[i - 1][k]);
            }
        }
        System.out.println(Integer.MAX_VALUE);

        return t[n][sum];
    }

    public static int minimumElements(int[] num, int x) {
        int[][] dp = new int[num.length][x+1];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);
        int y = coinChangeTabulationSpaceOptimized(num, x);
        if(y == (int)1e9)
            return -1;
        return y;
    }

    private static int coinChangeRecursion(int[] num, int target, int index, int[][] dp)
    {
        if(index == 0)
        {
            if(target % num[0] == 0)
                return target/num[0];
            else
                return (int)1e9;
        }
        if(dp[index][target] != -1) return dp[index][target];

        int notTake = coinChangeRecursion(num, target, index - 1, dp);
        int take = (int)1e9;
        if(num[index] <= target)
        {
            take = 1 + coinChangeRecursion(num, target-num[index], index, dp);
        }
        return dp[index][target]=Math.min(take, notTake);
    }

    private static int coinChangeTabulation(int[] num, int target)
    {
        int n = num.length;
        int[][] dp = new int[n][target+1];

        for(int i = 0; i<=target; i++)
        {
            if(i % num[0] == 0)
                dp[0][i] = i/num[0];
            else
                dp[0][i] = (int)1e9;
        }
        for(int i = 1; i<n; i++)
        {
            for(int j = 1; j<=target; j++)
            {
                int notTake = dp[i - 1][j];
                int take = (int)1e9;
                if(num[i] <= j)
                {
                    take = 1 + dp[i][j-num[i]];
                }
                dp[i][j]=Math.min(take, notTake);
            }
        }
        return dp[n-1][target];
    }

    private static int coinChangeTabulationSpaceOptimized(int[] num, int target)
    {
        int n = num.length;
        int[] prev = new int[target+1];

        for(int i = 0; i<=target; i++)
        {
            if(i % num[0] == 0)
                prev[i] = i/num[0];
            else
                prev[i] = (int)1e9;
        }
        for(int i = 1; i<n; i++)
        {
            int[] cur = new int[target+1];
            for(int j = 1; j<=target; j++)
            {
                int notTake = prev[j];
                int take = (int)1e9;
                if(num[i] <= j)
                {
                    take = 1 + cur[j-num[i]];
                }
                cur[j]=Math.min(take, notTake);
            }
            prev = cur;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int n = coins.length;
        int sum = 19;
        System.out.println("the min number of coins req is :" + coinChangeTabulation(coins, sum));
    }
}
