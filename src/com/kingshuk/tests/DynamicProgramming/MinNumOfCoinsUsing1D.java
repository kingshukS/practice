package com.kingshuk.tests.DynamicProgramming;

public class MinNumOfCoinsUsing1D {


    static int minNumCoins(int coins[], int n, int sum) {
        int[] t = new int[sum+1];

        // Initialize the array with infinity except for the value sum of 0, which needs 0 coins
        t[0] = 0;
        for(int i = 1; i<=sum; i++)
            t[i] = Integer.MAX_VALUE;

        for(int i = 1; i<=sum; i++)
        {
            for(int j = 0; j< n; j++)
            {
               if(coins[j] <= i){
                   int subsum = t[i-coins[j]];
                   if(subsum != Integer.MAX_VALUE && 1+subsum < t[i])
                       t[i] = 1+subsum;
               }
            }

        }
        if(t[sum] == Integer.MAX_VALUE)
            return -1;
        return t[sum];
    }

    public static void main(String args[]) {
        int coins[] = {1, 3, 5};
        int n = coins.length;
        int sum = 19;
        System.out.println("the min number of coins req is :" + minNumCoins(coins, n, sum));
    }
}
