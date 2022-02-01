package com.kingshuk.tests.AmazonQues;

public class NumberOfIslands {
    static int numIslands(char[][] grid)
    {
        if(grid==null || grid.length==0)
        {
            return 0;
        }

        int numIslands = 0;
        for(int i =0;i<grid.length;i++) // for every row
        {
            for(int j =0;j<grid[i].length;j++) //for every element of the row
            {
                if(grid[i][j] == '1') { //we need action only if we encounter 1 ,if 0 is encountered its of no use
                    numIslands += dfs(grid, i, j); //passing the grid and indicies on which we are on currently
                }
            }
        }
        return numIslands;
    }

    static int dfs(char[][] grid,int i ,int j)
    {
        if(i<0 || i >=grid.length || j<0 || j > grid[i].length || grid[i][j] == '0')
        {
            return 0;
        }

        grid[i][j] = '0'; //setting the visited cell as 0 so that we do not revisit the cell
        dfs(grid,i+1,j); //checking for down adjacent cells
        dfs(grid,i-1,j); //checking for up adjacent cells
        dfs(grid,i,j+1);//checking for right adjacent cells
        dfs(grid,i,j-1);//checking for left adjacent cells
        return 1;
    }

    public static void main(String args[])
    {
        char [][] grid = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                           {'0','0','0','0'}};
        int islands = numIslands(grid);
        System.out.print("The number of islands is "+islands);
    }
}
