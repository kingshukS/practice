package com.kingshuk.tests.hundredDaysChallenge.day1;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = findMaxProfit(prices);
        System.out.println("Max profit: "+maxProfit);
    }

    private static int findMaxProfit(int[] prices) {
        int maxProfit = 0, i = 1;
        int buy = prices[0];
        while(i<prices.length){
            if(prices[i]<buy)
                buy = prices[i];
            else if(maxProfit <= prices[i]-buy)
                maxProfit = prices[i] - buy;
            i++;
        }
        return maxProfit;
    }
}
