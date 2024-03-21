package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NumberOfDistinctIslands {

    private static int[][] DIRECTIONS = { { 0, - 1 }, { 0, 1 }, { - 1, 0 }, { 1, 0 } };

    int countDistinctIslands ( int[][] grid ) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Set<List<String>> set = new HashSet<> ();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( grid[i][j] == 1 && vis[i][j] == 0 ) {
                    List<String> list = new ArrayList<> ();
                    dfs ( grid, vis, i, j, list, i, j );
                    set.add ( list );
                }
            }
        }

        return set.size ();
    }

    private void dfs ( int[][] grid, int[][] vis, int row, int col, List<String> list, int baseRow, int baseCol ) {
        vis[row][col] = 1;
        list.add ( ( row - baseRow ) + "," + ( col - baseCol ) );

        for ( int[] dir : DIRECTIONS ) {
            int r = row + dir[0];
            int c = col + dir[1];

            if ( r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0 || vis[r][c] == 1 )
                continue;
            dfs ( grid, vis, r, c, list, baseRow, baseCol );
        }
    }
}
