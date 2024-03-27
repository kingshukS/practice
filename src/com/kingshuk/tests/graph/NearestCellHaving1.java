package com.kingshuk.tests.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class NearestCellHaving1 {
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest ( int[][] grid ) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] DIRECTIONS = { { 0, - 1 }, { 0, 1 }, { - 1, 0 }, { 1, 0 } };

        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Tuple> queue = new ArrayDeque<> ();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( grid[i][j] == 1 ) {
                    queue.add ( new Tuple ( i, j, 0 ) );
                    vis[i][j] = 1;
                }
            }
        }

        while (! queue.isEmpty ()) {
            Tuple t = queue.poll ();
            int x = t.x;
            int y = t.y;
            int d = t.d;

            dis[x][y] = d;

            for ( int[] dir : DIRECTIONS ) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if ( newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY] == 1 )
                    continue;

                vis[newX][newY] = 1;
                queue.add ( new Tuple ( newX, newY, d + 1 ) );
            }
        }

        return dis;
    }

    class Tuple {
        int x, y, d;

        Tuple ( int x, int y, int d ) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}