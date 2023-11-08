package com.kingshuk.tests.DynamicProgramming;

// K transactions
// 1 transaction = 1 buy + 1 sell
// No transaction can overlap
public class StockBuySell4 {
    public static int maximumProfit(int[] prices, int n, int k) {
        // 2*k states of txns => 0 to 2 * k - 1 =  : B(0)  S(1)   B(2)   S(3) ....
        int[] next = new int[2 * k + 1];
        int[] cur = new int[2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int txn = 2 * k - 1; txn >= 0; txn--) {
                int profit;
                if (txn % 2 == 0) {
                    profit = Math.max(-prices[index] + next[txn + 1], next[txn]);
                } else {
                    profit = Math.max(prices[index] + next[txn + 1], next[txn]);
                }
                cur[txn] = profit;
            }
            next = cur;
        }
        return next[0];
    }
}
