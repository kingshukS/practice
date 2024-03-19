package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {

    static int knapsack01(int[] wt, int[] value, int W, int n) {
        int[][] t = new int[n + 1][W + 1];
        int i, j;

        // either the knapsack has no capacity, i.e. W=0 or there are no objects present, i.e. n=0, so mac profit = 0
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
            }
        }
        return t[n][W];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return knapsackRecursive(weight, value, n-1, maxWeight, dp);
    }

    static int knapsackRecursive(int[] weight, int[] value, int index, int W, int[][] dp) {
        if (index == 0) {
            if (weight[0] <= W) return value[0];
            return 0;
        }

        if (dp[index][W] != -1) return dp[index][W];
        int notTake = knapsackRecursive(weight, value, index - 1, W, dp);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= W)
            take = value[index] + knapsackRecursive(weight, value, index - 1, W - weight[index], dp);

        return dp[index][W] = Math.max(take, notTake);
    }

    static int knapsackTabulation(int[] weight, int[] value, int n, int W) {
        int[][] dp = new int[n][W + 1];

        /*for (int i = 0; i <= W; i++) {
            if (weight[0] <= i)
                dp[0][i] = value[0];
        }*/
        for (int i = weight[0]; i <= W; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j)
                    take = value[i] + dp[i - 1][j - weight[i]];

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }

    static int knapsackTabulationSpaceOptimised(int[] weight, int[] value, int n, int W) {
        int[] prev = new int[W + 1];
        for (int i = weight[0]; i <= W; i++) {
            prev[i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[W + 1];
            for (int j = 0; j <= W; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j)
                    take = value[i] + prev[j - weight[i]];

                cur[j] = Math.max(take, notTake);
            }
            prev = cur;
        }
        return prev[W];
    }

    /**
     * There is no need to take cur array, reason is this: we are filling the cur values based on prev array (prev row) and not the cur. So we can store
     * the values in the same prev array instead of the cur. This is possible only if we are traversing from right to left. if we traverse left to right,
     * then we will end up taking overridden values from the left, not the original one from the prev row. In the prev array we are always taking values
     * from left side position i.e. prev[j - weight[i]].
     */
    static int knapsackTabulationSpaceOptimisedSuper(int[] weight, int[] value, int n, int W)
    {
        int[] prev = new int[W + 1];
        for (int i = weight[0]; i <= W; i++) {
            prev[i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j)
                    take = value[i] + prev[j - weight[i]];

                prev[j] = Math.max(take, notTake);
            }
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;
        int n = val.length;
        System.out.print(knapsack01(wt, val, W, n));
    }
}
