package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;
import java.util.List;

/**
 * Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any
 * transaction at all. What is the maximum profit?
 */
public class StockBuySellConditional {

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(7, 1, 5, 3, 6, 4);
        long maxProfit = stockMax(prices);
        System.out.println("Profit will be: "+maxProfit);
    }
    public static long stockMax(List<Integer> prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.size() - 1; i >= 0 ; i--) {
            if (prices.get(i) >= maxSoFar) {
                maxSoFar = prices.get(i);
            }
            profit += maxSoFar - prices.get(i);
        }
        return profit;
    }
}
