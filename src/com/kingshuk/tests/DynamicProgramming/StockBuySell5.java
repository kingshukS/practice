package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times)
 * with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class StockBuySell5 {
    public static int stockProfit(int[] price) {
        int n = price.length;
       int[][] dp = new int[n][2];
        for (int[] dpi : dp)
            Arrays.fill(dpi, -1);
        return f(0, 1, n, price, dp);
    }

    private static int f(int index, int buy, int n, int[] price, int[][] dp) {
        if (index >= n)
            return 0;

        if (dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-price[index] + f(index + 1, 0, n, price, dp), f(index + 1, 1, n, price, dp));
        } else {
            profit = Math.max(price[index] + f(index + 2, 1, n, price, dp), f(index + 1, 0, n, price, dp));
        }
        return dp[index][buy] = profit;
    }

    public static int stockProfitTabulation(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    profit = Math.max(-price[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    profit = Math.max(price[index] + dp[index + 2][1], dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int stockProfitTabulation2(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-price[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(price[index] + dp[index + 2][1], dp[index + 1][0]);

        }
        return dp[0][1];
    }
}
