package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class MaxNumOfWaysUsingCoins1D {


    static int MaxNumCoinsWays(int coins[], int n, int sum) {
        int[] t = new int[sum+1];

        // Initialize the array with 0 except for the value sum of 0, which needs 0 coins, 1 way
        Arrays.fill(t, 0);
        t[0] = 1;

        for (int i=0; i<n; i++)
            for (int j=coins[i]; j<=sum; j++)
                t[j] += t[j-coins[i]];

        return t[sum];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 3};
        int n = coins.length;
        int sum = 4;
        System.out.println("the max number of ways are :" + MaxNumCoinsWays(coins, n, sum));
    }
}
