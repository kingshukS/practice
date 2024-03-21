package com.kingshuk.tests.hundredDaysChallenge.day18;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color
 * as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of
 * all the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public static void main ( String[] args ) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        new FloodFill ().floodFill ( image, sr, sc, color );
        for ( int i = 0; i < image.length; i++ ) {
            for ( int j = 0; j < image[i].length; j++ ) {
                System.out.print ( image[i][j] + " " );
            }
            System.out.println ();
        }
    }

    public int[][] floodFill ( int[][] image, int sr, int sc, int color ) {
        if ( image[sr][sc] == color ) return image;
        floodFillDoColor ( image, sr, sc, image[sr][sc], color );
        return image;
    }

    public void floodFillDoColor ( int[][] image, int sr, int sc, int startingColor, int color ) {
        if ( sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != startingColor )
            return;
        image[sr][sc] = color;
        floodFillDoColor ( image, sr, sc + 1, startingColor, color );
        floodFillDoColor ( image, sr, sc - 1, startingColor, color );
        floodFillDoColor ( image, sr - 1, sc, startingColor, color );
        floodFillDoColor ( image, sr + 1, sc, startingColor, color );
    }
}
