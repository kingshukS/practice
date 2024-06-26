package com.kingshuk.tests.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// unlimited transactions, once bought, it must be sold first before another buy
public class StockBuySell2 {
    public static long getMaximumProfit ( int n, long[] price ) {
        long[][] dp = new long[n][2];
        for ( long[] dpi : dp )
            Arrays.fill ( dpi, - 1L );
        return f ( 0, 1, n, price, dp );
    }

    private static long f ( int index, int canBuy, int n, long[] price, long[][] dp ) {
        if ( index == n )
            return 0L;

        if ( dp[index][canBuy] != - 1L ) return dp[index][canBuy];
        long profit = 0L;
        if ( canBuy == 1 ) {
            profit = Math.max ( - price[index] + f ( index + 1, 0, n, price, dp ), f ( index + 1, 1, n, price, dp ) );
        } else {
            profit = Math.max ( price[index] + f ( index + 1, 1, n, price, dp ), f ( index + 1, 0, n, price, dp ) );
        }
        return dp[index][canBuy] = profit;
    }

    public static long getMaximumProfitTabulation ( int n, long[] price ) {
        long[][] dp = new long[n + 1][2];
        dp[n][0] = 0L;
        dp[n][1] = 0L;

        for ( int index = n - 1; index >= 0; index-- ) {
            for ( int buy = 0; buy <= 1; buy++ ) {
                long profit;
                if ( buy == 1 ) {
                    profit = Math.max ( - price[index] + dp[index + 1][0], dp[index + 1][1] );
                } else {
                    profit = Math.max ( price[index] + dp[index + 1][1], dp[index + 1][0] );
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static long getMaximumProfitSpaceOptimization ( int n, long[] price ) {
        long[] next = new long[2];
        long[] cur;

        for ( int index = n - 1; index >= 0; index-- ) {
            cur = new long[2];
            for ( int buy = 0; buy <= 1; buy++ ) {
                long profit;
                if ( buy == 1 ) {
                    profit = Math.max ( - price[index] + next[0], next[1] );
                } else {
                    profit = Math.max ( price[index] + next[1], next[0] );
                }
                cur[buy] = profit;
            }
            next = cur;
        }
        return next[1];
    }

    public static long getMaximumProfitSpaceOptimizationMax ( int n, long[] price ) {
        long nextBuy = 0L, nextNotBuy = 0L;
        long curBuy, curNotBuy;

        for ( int index = n - 1; index >= 0; index-- ) {
            curBuy = Math.max ( - price[index] + nextNotBuy, nextBuy );
            curNotBuy = Math.max ( price[index] + nextBuy, nextNotBuy );
            nextNotBuy = curNotBuy;
            nextBuy = curBuy;
        }
        return nextBuy;
    }

    //Local minima (@buy) and local maxima (@sell)
    private static void findMaxProfitForMultipleTxns ( int[] price, int n ) {
        if ( n == 1 )
            return;
        List<Interval> txnList = new ArrayList<> ();
        int i = 0, count = 0;
        while (i < n - 1) {
            while (i < n - 1 && price[i + 1] <= price[i])
                i++;
            if ( i == n - 1 )
                break;
            Interval e = new Interval ();
            e.buy = i++;
            while (i < n && price[i] > price[i - 1])
                i++;
            e.sell = i - 1;
            txnList.add ( e );
            count++;
        }
        if ( count == 0 )
            System.out.println ( "There is no day when buying the stock will make profit" );
        else {
            int maxProfit = 0;
            for ( int j = 0; j < count; j++ ) {
                System.out.println ( "Buy on day: " + txnList.get ( j ).buy + " Sell on day : " + txnList.get ( j ).sell );
                maxProfit += ( price[txnList.get ( j ).sell] - price[txnList.get ( j ).buy] );
            }
            System.out.println ( "Maximum Profit: " + maxProfit );
        }
    }

    static class Interval {
        int buy;
        int sell;
    }
}

