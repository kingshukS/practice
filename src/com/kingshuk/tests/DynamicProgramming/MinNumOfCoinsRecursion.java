package com.kingshuk.tests.DynamicProgramming;

public class MinNumOfCoinsRecursion {


    public static int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int noOfCoins = minCoinsUtil(coins, M, V);
        if (noOfCoins >= Integer.MAX_VALUE - 1)
            return -1;
        return noOfCoins;
    }

    public static int minCoinsUtil(int coins[], int M, int V) {
        // Your code goes here
        if (V == 0)
            return 0;
        if (M == 0)
            return Integer.MAX_VALUE - 1;

        if (coins[M - 1] > V)
            return minCoinsUtil(coins, M - 1, V);
        else
            return Math.min(minCoinsUtil(coins, M - 1, V), 1 + minCoinsUtil(coins, M, V - coins[M - 1]));
    }

    public static void main(String args[]) {
        int coins[] = {25, 10, 15};
        int n = coins.length;
        int sum = 30;
        System.out.println("the min number of coins req is :" + minCoins(coins, n, sum));
    }
}
