package com.kingshuk.tests.graph;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclaves {

    int[][] DIRECTIONS = { { 0, - 1 }, { 0, 1 }, { 1, 0 }, { - 1, 0 } };

    private void dfs ( int[][] grid, int[][] vis, int row, int col ) {
        vis[row][col] = 1;

        for ( int[] dir : DIRECTIONS ) {
            int x = row + dir[0];
            int y = col + dir[1];

            if ( x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || vis[x][y] == 1 || grid[x][y] == 0 )
                continue;
            dfs ( grid, vis, x, y );
        }
    }

    int numberOfEnclaves ( int[][] grid ) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> queue = new LinkedList<> ();
        // Left and Right Boundary
        for ( int i = 0; i < n; i++ ) {
            if ( grid[i][0] == 1 && vis[i][0] == 0 ) {
                queue.add ( new Pair ( i, 0 ) );
                vis[i][0] = 1;
                //dfs(grid, vis, i, 0);
            }
            if ( grid[i][m - 1] == 1 && vis[i][m - 1] == 0 ) {
                queue.add ( new Pair ( i, m - 1 ) );
                vis[i][m - 1] = 1;
                //dfs(grid, vis, i, m-1);
            }
        }

        // Up and Down Boundary
        for ( int i = 0; i < m; i++ ) {
            if ( grid[0][i] == 1 && vis[0][i] == 0 ) {
                queue.add ( new Pair ( 0, i ) );
                vis[0][i] = 1;
                //dfs(grid, vis, 0, i);
            }

            if ( grid[n - 1][i] == 1 && vis[n - 1][i] == 0 ) {
                queue.add ( new Pair ( n - 1, i ) );
                vis[n - 1][i] = 1;
                //dfs(grid, vis, n-1, i);
            }
        }

        while (! queue.isEmpty ()) {
            Pair p = queue.poll ();
            int row = p.r;
            int col = p.c;

            for ( int[] dir : DIRECTIONS ) {
                int x = row + dir[0];
                int y = col + dir[1];

                if ( x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || vis[x][y] == 1 || grid[x][y] == 0 )
                    continue;
                queue.add ( new Pair ( x, y ) );
                vis[x][y] = 1;
            }
        }

        int count = 0;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( grid[i][j] == 1 && vis[i][j] == 0 )
                    count++;
            }
        }
        return count;
    }

    class Pair {
        int r, c;

        Pair ( int r, int c ) {
            this.r = r;
            this.c = c;
        }
    }
}