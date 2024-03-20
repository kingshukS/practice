package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

// 2 transactions
// 1 transaction = 1 buy + 1 sell
// No transaction can overlap
public class StockBuySell3 {

    public static int maxProfitTxn(int[] prices) {
        // 4 states : B(0)  S(1)   B(2)   S(3)
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);
        return fTxn(0, 0, prices, n, dp);
    }

    private static int fTxn(int index, int txn, int[] prices, int n, int[][] dp) {
        if(index == n)
            return 0;
        if(txn == 4)
            return 0;

        if(dp[index][txn] != -1) return dp[index][txn];
        int profit = 0;
        if(txn % 2 == 0)
        {
            profit = Math.max(-prices[index] + fTxn(index+1, txn+1, prices, n, dp), fTxn(index+1, txn, prices, n, dp));
        }else{
            profit = Math.max(prices[index] + fTxn(index+1, txn+1, prices, n, dp), fTxn(index+1, txn, prices, n, dp));
        }
        return dp[index][txn]=profit;
    }

    public static int maxProfitTxnTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];

        // base cases
        for(int txn = 0; txn<=4; txn++)
            dp[txn][n] = 0;
        for(int index = 0; index<=n; index++)
            dp[index][4] = 0;

        for(int index = n-1; index>=0; index-- )
        {
            for(int txn = 3; txn>=0; txn--)
            {
                int profit;
                if(txn % 2 == 0)
                {
                    profit = Math.max(-prices[index] + dp[index+1] [txn+1], dp[index+1] [txn]);
                }else{
                    profit = Math.max(prices[index] + dp[index+1] [txn+1], dp[index+1] [txn]);
                }
                dp[index][txn]=profit;
            }
        }

        return dp[0][0];
    }

    public static int maxProfitTxnSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] next = new int[5];
        int[] cur;

        for(int index = n-1; index>=0; index-- )
        {
            cur = new int[5];
            for(int txn = 3; txn>=0; txn--)
            {
                int profit;
                if(txn % 2 == 0)
                {
                    profit = Math.max(-prices[index] + next [txn+1], next [txn]);
                }else{
                    profit = Math.max(prices[index] + next [txn+1], next [txn]);
                }
                cur[txn]=profit;
            }
            next = cur;
        }
        return next[0];
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for(int[][] dpi : dp)
        {
            for(int[] dpii : dpi)
            {
                Arrays.fill(dpii, -1);
            }
        }
        return f(0, 1, 2, prices, n, dp);
    }

    private static int f(int index, int buy, int cap, int[] prices, int n, int[][][] dp)
    {
        if(index == n)
            return 0;
        if(cap == 0)
            return 0;

        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        int profit = 0;
        if(buy == 1)
        {
            profit = Math.max(-prices[index] + f(index+1, 0, cap, prices, n, dp), f(index+1, 1, cap, prices, n, dp));
        }else{
            profit = Math.max(prices[index] + f(index+1, 1, cap-1, prices, n, dp), f(index+1, 0, cap, prices, n, dp));
        }

        return dp[index][buy][cap]=profit;
    }

    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        /*
        // base case - initialization 1
        for(int buy=0; buy<=1; buy++)
        {
            for(int cap = 0; cap<=2; cap++)
            {
                dp[n][buy][cap] = 0;
            }
        }
        // base case - initialization 2
        for(int index=0; index<=n; index++)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                dp[index][buy][0] = 0;
            }
        }
        */

        for(int index=n-1; index>=0; index--)
        {
            for(int buy = 1; buy>=0; buy--)
            {
                for(int cap = 2; cap>=1; cap--)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        profit = Math.max(-prices[index] + dp[index+1] [0] [cap], dp[index+1] [1] [cap]);
                    }else{
                        profit = Math.max(prices[index] + dp[index+1] [1] [cap-1], dp[index+1] [0] [cap]);
                    }

                    dp[index][buy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
    }

    public static int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];
        int[][] cur = new int[2][3];

        for(int index=n-1; index>=0; index--)
        {
            for(int buy = 1; buy>=0; buy--)
            {
                for(int cap = 2; cap>=1; cap--)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        profit = Math.max(-prices[index] + next[0] [cap], next[1] [cap]);
                    }else{
                        profit = Math.max(prices[index] + next[1] [cap-1], next[0] [cap]);
                    }
                    cur[buy][cap]=profit;
                }
            }
            next = cur;
        }
        return next[1][2];
    }
}