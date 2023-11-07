package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);
        return f(n, m, s, t, dp);
    }

    private int f(int index1, int index2, String s, String t, int[][] dp)
    {
        if(index2==0)
            return 1;

        if(index1==0)
            return 0;
        
        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(s.charAt(index1-1) == t.charAt(index2-1))
        {
            return dp[index1][index2]=f(index1-1, index2-1, s, t, dp) + f(index1-1, index2, s, t, dp);
        }
        else
            return dp[index1][index2]=f(index1-1, index2, s, t, dp);
    }

    public int numDistinctTabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<=n; i++)
            dp[i][0] = 1;

        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][m];
    }

    public int numDistinctSpaceOptimization(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m+1];

        dp[0] = 1;

        for(int i = 1; i<=n; i++)
        {
            for(int j = m; j>=1; j--)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[j]=dp[j-1] + dp[j];
                }
            }
        }

        return dp[m];
    }
}