package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

class PartitionArrayForMaxSum {

    public static void main(String[] args) {
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;
        System.out.println(new PartitionArrayForMaxSum().maxSumAfterPartitioning(arr, k));
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, arr, n, k, dp);
    }

    public int maxSumAfterPartitioningTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--)
        {
            int sum = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            for(int ind = i, count = 0; ind<n && count<k; count++, ind++)
            {
                maxi = Math.max(maxi, arr[ind]);
                int res = (maxi * (ind-i+1)) + dp[ind+1];
                sum = Math.max(sum, res);
            }
            dp[i]=sum;
        }
        return dp[0];
    }

    private int f(int i, int[] arr, int n, int k, int[] dp) {
        if(i == n)
            return 0;
        if(dp[i] != -1) return dp[i];
        int sum = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int ind = i, count = 0; ind<n && count<k; count++, ind++)
        {
            maxi = Math.max(maxi, arr[ind]);
            int res = (maxi * (ind-i+1)) + f(ind+1, arr, n, k, dp);
            sum = Math.max(sum, res);
        }
        return dp[i]=sum;
    }
}