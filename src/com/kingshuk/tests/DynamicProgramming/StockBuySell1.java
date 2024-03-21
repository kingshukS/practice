package com.kingshuk.tests.DynamicProgramming;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class StockBuySell1 {
    public static void main ( String[] args ) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = findMaxProfit ( prices );
        System.out.println ( "Max profit: " + maxProfit );
    }

    private static int findMaxProfit ( int[] prices ) {
        int maxProfit = 0, i = 1;
        int buy = prices[0];
        while (i < prices.length) {
            if ( prices[i] < buy )
                buy = prices[i];
            else if ( maxProfit <= prices[i] - buy )
                maxProfit = prices[i] - buy;
            i++;
        }
        return maxProfit;
    }

    private static int findMaxProfit2 ( int[] prices ) {
        int n = prices.length;
        int maxProfit = 0;
        int maxSellingPrice = prices[n - 1];
        for ( int i = n - 2; i >= 0; i-- ) {
            if ( prices[i] < maxSellingPrice ) {
                maxProfit = Math.max ( maxProfit, maxSellingPrice - prices[i] );
            } else {
                maxSellingPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
