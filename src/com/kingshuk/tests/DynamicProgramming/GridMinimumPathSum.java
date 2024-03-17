package com.kingshuk.tests.DynamicProgramming;

public class GridMinimumPathSum {
    private static int minSumPathUtilRecursion(int i, int j, int[][] grid)
    {
        if(i == 0 && j == 0)
            return grid[i][j];
        if(i<0 || j<0)
            return (int)1e9;
        
        int up = grid[i][j] + minSumPathUtilRecursion(i-1, j, grid);
        int left = grid[i][j] + minSumPathUtilRecursion(i, j-1, grid);

        return Math.min(up, left);
    }

     public static int minSumPathMemoization(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         int[][] dp = new int[n][m];
         for(int i = 0; i<n; i++)
             for(int j = 0; j<m; j++)
                 dp[i][j] = -1;
     	return minSumPathUtil(n-1, m-1, grid, dp);
     }

    private static int minSumPathUtil(int i, int j, int[][] grid, int[][] dp)
    {
        if(i == 0 && j == 0)
            return grid[i][j];
        if(i<0 || j<0)
            return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + minSumPathUtil(i-1, j, grid, dp);
        int left = grid[i][j] + minSumPathUtil(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

     public static int minSumPathTabulation(int[][] grid)
     {
         int n = grid.length;
         int m = grid[0].length;
         int[][] dp = new int[n][m];

         for(int i = 0; i<n; i++)
         {
             for(int j = 0; j<m; j++)
             {
                 if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                 else{
                     int up = grid[i][j];
                     int left = grid[i][j];

                     if(i==0) up = (int)1e9;
                     else up+=dp[i-1][j];

                     if(j==0)left = (int)1e9;
                     else left+= dp[i][j-1];

                     dp[i][j] = Math.min(up, left);
                 }
             }
         }
         return dp[n-1][m-1];
     }

    public static int minSumPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];

        for(int i = 0; i<n; i++)
        {
            int[] cur = new int[m];
            for(int j = 0; j<m; j++)
            {
                if(i == 0 && j == 0) cur[j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i==0) up = (int)1e9;
                    else up+=prev[j];

                    if(j==0)left = (int)1e9;
                    else left+= cur[j-1];

                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[m-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{5,9,6},{11,5,2}};
        System.out.println(minSumPath(grid));
    }
}