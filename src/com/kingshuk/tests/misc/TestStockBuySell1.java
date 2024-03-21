package com.kingshuk.tests.misc;

public class TestStockBuySell1 {
    public static void main ( String[] args ) {
        int[] arr = { 1, 5, 3, 1, 2, 8 };
        int n = arr.length;
        int profit = findMaximumProfit ( arr, n );
        int profit2 = findMaximumProfit ( arr );
        System.out.println ( "Profit:" + profit );
        System.out.println ( "Profit2:" + profit2 );
    }

    private static int findMaximumProfit ( int[] arr, int n ) {
        int profit = 0;
        int i = 0;
        int j = 0;
        while (i < n) {

            // local minima
            while (i < n - 1 && arr[i] > arr[i + 1])
                i++;

            if ( i == n - 1 )
                return profit;

            // initialize j, next to i to find the local maxima
            j = i + 1;
            while (j < n && arr[j] > arr[j - 1])
                j++;

            // add the difference to profit
            profit += arr[j - 1] - arr[i];

            // re-iterate
            i = j;
        }
        return profit;
    }

    // If price is going down, don't do anything until it reaches the bottom-point. When it's going up add-up all the profits
    // where the cumulative sum will give the actual difference between peek and bottom points
    private static int findMaximumProfit ( int[] arr ) {
        int n = arr.length;
        int profit = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( arr[i] > arr[i - 1] ) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
}
