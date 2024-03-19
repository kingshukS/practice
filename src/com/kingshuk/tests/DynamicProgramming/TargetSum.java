package com.kingshuk.tests.DynamicProgramming;

import java.util.* ;

public class TargetSum {
    public static int targetSum(int n, int target, int[] arr) {
    	int s = 0;
        for(int x : arr)
            s+=x;
        int sum = s+target;
        if(sum % 2 != 0 || sum<0) return 0;

        int[][] dp = new int[n][sum/2 + 1];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);
        return subsetCount(arr, n-1, sum/2, dp);
    }

    private static int subsetCount(int[] arr, int index, int sum, int[][] dp)
    {
        if(index == 0)
        {
            if(sum == 0 && arr[0] == 0)
                return 2;
            if(arr[0] == sum || sum == 0)
                return 1;
            return 0;
        }

        if(dp[index][sum] != -1) return dp[index][sum];

        int notTake = subsetCount(arr, index-1, sum, dp);
        int take = 0;
        if(arr[index]<= sum)
            take = subsetCount(arr, index-1, sum-arr[index], dp);
        return dp[index][sum] = take+notTake;
    }
}