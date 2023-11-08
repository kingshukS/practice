package com.kingshuk.tests.DynamicProgramming;

// unlimited transactions
// 1 transaction = 1 buy + 1 sell
// transaction fee for every complete transaction applicable

public class StockBuySell6 {
    public static int maximumProfit(int[] price, int n, int fee) {
        int aheadBuy = 0, aheadNotBuy = 0;
        int curBuy, curNotBuy;

        for (int index = n - 1; index >= 0; index--)
        {
            curBuy = Math.max(-price[index] + aheadNotBuy, aheadBuy);
            curNotBuy = Math.max(price[index] -fee + aheadBuy, aheadNotBuy);
            aheadNotBuy = curNotBuy;
            aheadBuy = curBuy;
        }
        return aheadBuy;
    }
}