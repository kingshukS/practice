package com.kingshuk.tests.graph;

class Replace0WithX {
    static int[][] DIRECTIONS = { { 0, - 1 }, { 0, 1 }, { - 1, 0 }, { 1, 0 } };

    static char[][] fill ( int n, int m, char[][] a ) {
        int[][] vis = new int[n][m];

        for ( int i = 0; i < n; i++ ) {
            if ( a[i][0] == 'O' && vis[i][0] == 0 )
                dfs ( a, vis, i, 0 );

            if ( a[i][m - 1] == 'O' && vis[i][m - 1] == 0 )
                dfs ( a, vis, i, m - 1 );

        }

        for ( int i = 0; i < m; i++ ) {
            if ( a[0][i] == 'O' && vis[0][i] == 0 )
                dfs ( a, vis, 0, i );

            if ( a[n - 1][i] == 'O' && vis[n - 1][i] == 0 )
                dfs ( a, vis, n - 1, i );
        }

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( a[i][j] == 'O' && vis[i][j] == 0 )
                    a[i][j] = 'X';
            }
        }
        return a;
    }

    static void dfs ( char[][] a, int[][] vis, int row, int col ) {
        vis[row][col] = 1;

        for ( int[] dir : DIRECTIONS ) {
            int newX = row + dir[0];
            int newY = col + dir[1];

            if ( newX < 0 || newX >= a.length || newY < 0 || newY >= a[newX].length || a[newX][newY] != 'O'
                    || vis[newX][newY] == 1 )
                continue;

            dfs ( a, vis, newX, newY );
        }
    }
}