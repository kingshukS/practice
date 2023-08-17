package com.kingshuk.tests.hundredDaysChallenge.day18;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }

    public int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    public int islandPerimeter3(int[][] grid) {
        int ans = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    ans+=findP(grid, i, j+1);
                    ans+=findP(grid, i, j-1);
                    ans+=findP(grid, i-1, j);
                    ans+=findP(grid, i+1, j);
                }
            }
        }
        return ans;
    }
    int findP(int[][] grid, int i , int j)
    {
        if(i<0 || j<0 || i>=grid.length || j >= grid[i].length || grid[i][j] == 0)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        ip.islandPerimeter3(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});
    }
}
