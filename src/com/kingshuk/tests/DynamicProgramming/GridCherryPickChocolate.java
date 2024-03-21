package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

class GridCherryPickChocolate {
    // Function to find the maximum number of chocolates using dynamic programming
    static int maxChocoUtil ( int i, int j1, int j2, int n, int m, int[][] grid,
                              int[][][] dp ) {
        // Check if j1 and j2 are valid column indices
        if ( j1 < 0 || j1 >= m || j2 < 0 || j2 >= m )
            return (int) ( Math.pow ( - 10, 9 ) );

        // If we are at the last row, return the sum of chocolates in the selected columns
        if ( i == n - 1 ) {
            if ( j1 == j2 )
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        // If the result for this state is already computed, return it
        if ( dp[i][j1][j2] != - 1 )
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        // Iterate through possible moves in the next row
        for ( int di = - 1; di <= 1; di++ ) {
            for ( int dj = - 1; dj <= 1; dj++ ) {
                int ans;
                // If j1 and j2 are the same, add chocolates from grid[i][j1] only
                if ( j1 == j2 )
                    ans = grid[i][j1] + maxChocoUtil ( i + 1, j1 + di, j2 + dj, n, m, grid, dp );
                else
                    // Add chocolates from both j1 and j2
                    ans = grid[i][j1] + grid[i][j2] + maxChocoUtil ( i + 1, j1 + di, j2 + dj, n, m, grid, dp );
                // Update maxi with the maximum result
                maxi = Math.max ( maxi, ans );
            }
        }
        // Store the result in the dp array and return it
        return dp[i][j1][j2] = maxi;
    }

    // Function to find the maximum number of chocolates
    static int maximumChocolates ( int n, int m, int[][] grid ) {
        // Create a 3D array to store computed results
        int[][][] dp = new int[n][m][m];

        // Initialize the dp array with -1
        for ( int[][] row1 : dp ) {
            for ( int[] row2 : row1 ) {
                Arrays.fill ( row2, - 1 );
            }
        }

        // Call the utility function to find the maximum number of chocolates
        return maxChocoUtil ( 0, 0, m - 1, n, m, grid, dp );
    }

    public static void main ( String[] args ) {
        int[][] matrix = { { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } };
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println ( maximumChocolates ( n, m, matrix ) );
    }
}
