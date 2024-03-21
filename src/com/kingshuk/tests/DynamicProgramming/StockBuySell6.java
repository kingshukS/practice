package com.kingshuk.tests.DynamicProgramming;

// unlimited transactions
// 1 transaction = 1 buy + 1 sell
// transaction fee for every complete transaction applicable

public class StockBuySell6 {
    public static int maximumProfit ( int[] price, int n, int fee ) {
        int nextBuy = 0, nextNotBuy = 0;
        int curBuy, curNotBuy;

        for ( int index = n - 1; index >= 0; index-- ) {
            curBuy = Math.max ( - price[index] + nextNotBuy, nextBuy );
            curNotBuy = Math.max ( price[index] - fee + nextBuy, nextNotBuy );
            nextNotBuy = curNotBuy;
            nextBuy = curBuy;
        }
        return nextBuy;
    }
}