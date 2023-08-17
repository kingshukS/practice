package graph;

import java.util.ArrayDeque;
import java.util.Queue;

class NumOfIslandsGFG {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int[][] vis = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    if(vis[i][j] != 1)
                    {
                        count++;
                        bfs(grid, i, j, vis);
                    }
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int row, int col, int[][] vis)
    {
        int[] ROWS = {-1,-1,-1,0,0,1,1,1};
        int[] COLS = {-1,0,1,-1,1,-1,0,1};
        
        vis[row][col] = 1;
        
        for(int i = 0; i<8; i++)
        {
            int r = row + ROWS[i];
            int c = col + COLS[i];
            if(r<0 || r>=grid.length || c<0 || c>=grid[r].length || grid[r][c] == '0' || vis[r][c] == 1)
            {
                continue;
            }
            dfs(grid, r, c, vis);
        }
    }

    private void bfs(char[][] grid, int row, int col, int[][] vis)
    {
        int[] ROWS = {-1,-1,-1,0,0,1,1,1};
        int[] COLS = {-1,0,1,-1,1,-1,0,1};

        vis[row][col] = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, col));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int x = pair.i;
            int y = pair.j;

            for(int i = 0; i<8; i++)
            {
                int r = x + ROWS[i];
                int c = y + COLS[i];
                if(r<0 || r>=grid.length || c<0 || c>=grid[r].length || grid[r][c] == '0' || vis[r][c] == 1)
                {
                    continue;
                }
                vis[r][c] = 1;
                queue.add(new Pair(r, c));
            }
        }
    }

    class Pair{
        int i, j;
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        NumOfIslandsGFG numOfIslands = new NumOfIslandsGFG();
        char[][] grid = {{'0','1', '0'}, {'0','1', '0'}, {'0','0', '0'}, {'1','1', '0'}, {'1','0', '1'}, {'0','1', '1'}, {'1','1', '1'}, {'0','1', '1'}, {'1','0', '1'}};
        System.out.println(numOfIslands.numIslands(grid));
    }
}