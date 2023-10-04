package com.kingshuk.tests.DynamicProgramming;

public class LongestIncreasingSubsequence {

    private static int[][] dp;

    private static int LIS = Integer.MIN_VALUE;
    static int longestLength(int arr[], int n) {
        int i, j, max = 0;
        int lis[] = new int[n];

        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    static int longestLengthRecursive(int arr[], int n) {
        if(n == 1)
            return 1;

        int max_ending_here = 1, res = 0;

        for(int i = 1; i<n; i++)
        {
            res = longestLengthRecursive(arr, i);

            if(arr[n-1] > arr[i-1] && 1 + res > max_ending_here)
                max_ending_here = 1 + res;
        }

        LIS = Math.max(LIS, max_ending_here);

        return max_ending_here;
    }

    private static int findLis2(int[] arr, int n) {
        int[] dp = new int[n], backtrack = new int[n];

        for(int i = 0; i<n; i++)
        {
            dp[i] = 1;
            backtrack[i] = i;
            for(int j = 0; j<i; j++)
            {
                if(arr[i]> arr[j] && dp[j]+1>dp[i])
                {
                    dp[i] = dp[j]+1;
                    backtrack[i] = j;
                }
            }
        }
        int max = dp[0];
        int maxIndex = 0;
        for(int i = 1; i<n; i++)
        {
            if(dp[i]> max)
            {
                max = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> lisList = new ArrayList<>();

        while(backtrack[maxIndex] != maxIndex)
        {
            lisList.add(arr[maxIndex]);
            maxIndex = backtrack[maxIndex];
        }
        lisList.add(arr[maxIndex]);
        Collections.sort(lisList);
        System.out.println(lisList);
        return max;
    }

    private static int findLis(int[] arr, int n) {
        int[] next = new int[n+1], cur = new int[n+1];
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int pInd = ind-1; pInd>=-1; pInd--)
            {
                int len = next[pInd+1];
                if(pInd == -1 || arr[ind] > arr[pInd]) {
                    len = Math.max(1 +next[ind+1], len);
                }
                cur[pInd+1] = len;
            }
            next = cur;
        }
        return next[0];
    }

    private static int findLis(int[] arr, int index, int prev) {
        if(index == arr.length)
            return 0;
        int len = dp[index+1][prev+1] != -1? dp[index+1][prev+1]: findLis(arr, index+1, prev);
        if(prev == -1 || arr[index] > arr[prev]) {
            int x = dp[index+1][index+1] != -1? dp[index+1][index+1]: findLis(arr, index+1, index);
            len = Math.max(1 +x, len);
        }
        return dp[index+1][prev+1] = len;
    }

    

    public static void main(String args[]) {
        int arr[] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int n = arr.length;
        dp = new int[n+1][n+1];
        /*for(int x = 0; x< dp.length; x++)
            Arrays.fill(dp[x], -1);*/
        //System.out.println("LIS::> "+findLis(arr, 0, -1));
        System.out.println(findLis2(arr, n));
    }
}
