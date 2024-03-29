package com.kingshuk.tests.graph;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class FloodFill {
    int[][] DIRECTIONS = { { 0, - 1 }, { 0, 1 }, { - 1, 0 }, { 1, 0 } };

    public static void main ( String[] args ) {
        int[][] image = { { 0, 0, 0 }, { 0, 0, 0 } };
        int sr = 0, sc = 0, color = 0;
        new FloodFill ().floodFill ( image, sr, sc, color );
        System.out.println ( Arrays.deepToString ( image ) );
    }

    private void floodFill ( int[][] image, int sr, int sc, int color ) {
        if ( image[sr][sc] == color )
            return;
        dfs ( image, sr, sc, image[sr][sc], color );
    }

    private void bfs ( int[][] image, int sr, int sc, int startingColor, int color ) {
        image[sr][sc] = color;
        Queue<Pair> pairQueue = new ArrayDeque<> ();
        pairQueue.add ( new Pair ( sr, sc ) );
        while (! pairQueue.isEmpty ()) {
            Pair p = pairQueue.poll ();
            int i = p.i;
            int j = p.j;
            for ( int[] x : DIRECTIONS ) {
                int newI = i + x[0];
                int newJ = j + x[1];
                if ( newI < 0 || newI >= image.length || newJ < 0 || newJ >= image[newI].length || image[newI][newJ] != startingColor )
                    continue;
                image[newI][newJ] = color;
                pairQueue.add ( new Pair ( newI, newJ ) );
            }
        }
    }

    void dfs ( int[][] image, int sr, int sc, int startingColor, int color ) {
        if ( sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != startingColor )
            return;
        image[sr][sc] = color;
        dfs ( image, sr, sc - 1, startingColor, color );
        dfs ( image, sr, sc + 1, startingColor, color );
        dfs ( image, sr - 1, sc, startingColor, color );
        dfs ( image, sr + 1, sc, startingColor, color );
    }

    class Pair {
        int i, j;

        Pair ( int i, int j ) {
            this.i = i;
            this.j = j;
        }
    }
}