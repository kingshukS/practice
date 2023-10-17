package com.kingshuk.tests.DynamicProgramming;

public class MinimumPathSumTriangle {
     public static int minimumPathSumTriangle(int[][] triangle, int n) {
         int[][] dp = new int[n][n];
         for(int i = 0; i<n; i++)
         {
             for(int j = 0; j<n; j++)
             {
                 dp[i][j] = -1;
             }
         }
         return minimumPathSumTriangleUtilMemoized(0,0, triangle, n, dp);
     }

    private static int minimumPathSumTriangleUtilMemoized(int i, int j, int[][] triangle, int n, int[][] dp)
    {
        if(i == n-1)
            return triangle[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + minimumPathSumTriangleUtilMemoized(i+1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumTriangleUtilMemoized(i+1, j+1, triangle, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

     public static int minimumPathSumTriangleTabulation(int[][] triangle, int n)
     {
         int[][] dp = new int[n][n];

         for(int i = 0; i<n; i++)
             dp[n-1][i] = triangle[n-1][i];
        
         for(int i = n-2; i>= 0; i--)
         {
             for(int j = 0; j<=i; j++)
             {
                 int down = triangle[i][j] + dp[i+1][j];
                 int diagonal = triangle[i][j] + dp[i+1][j+1];
                 dp[i][j] = Math.min(down, diagonal);
             }
         }

         return dp[0][0];
     }

    public static int minimumPathSumTriangleSpaceOptimized(int[][] triangle, int n)
    {
        int[] next = new int[n];

        for(int i = 0; i<n; i++)
            next[i] = triangle[n-1][i];
        
        for(int i = n-2; i>= 0; i--)
        {
            int[] cur = new int[i+1];
            for(int j = 0; j<=i; j++)
            {
                int down = triangle[i][j] + next[j];
                int diagonal = triangle[i][j] + next[j+1];
                cur[j] = Math.min(down, diagonal);
            }
            next = cur;
        }

        return next[0];
    }
}