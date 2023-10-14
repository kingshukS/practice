package com.kingshuk.tests.DynamicProgramming;

public class GridUniquePath {
    private static int gridUniquePathUtil(int i, int j)
    {
        if(i == 0 && j == 0)
            return 1;
        if(i<0 || j<0)
            return 0;
        
        int up = gridUniquePathUtil(i-1, j);
        int left = gridUniquePathUtil(i, j-1);

        return Math.min(up, left);
    }

    /*public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                dp[i][j] = -1;
        return gridUniquePathUtil(m-1, n-1, dp);
    }*/

    private static int gridUniquePathUtil(int i, int j, int[][] dp)
    {
        if(i == 0 && j == 0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = gridUniquePathUtil(i-1, j, dp);
        int left = gridUniquePathUtil(i, j-1, dp);

        return dp[i][j] = up+left;
    }

     public static int uniquePaths(int m, int n)
     {
         int[][] dp = new int[m][n];

         for(int i = 0; i<m; i++)
         {
             for(int j = 0; j<n; j++)
             {
                 if(i == 0 && j == 0) dp[i][j] = 1;
                 else{
                     int up = i>0?dp[i-1][j] : 0;
                     int left = j>0?dp[i][j-1] : 0;

                     dp[i][j] = up + left;
                 }
             }
         }
         return dp[m-1][n-1];
     }

    public static int uniquePaths2(int m, int n)
    {
        int[] prev = new int[n];

        for(int i = 0; i<m; i++)
        {
            int[] cur = new int[n];
            for(int j = 0; j<n; j++)
            {
                if(i == 0 && j == 0) cur[j] = 1;
                else{
                    int up = i>0?prev[j] : 0;
                    int left = j>0?cur[j-1] : 0;

                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}