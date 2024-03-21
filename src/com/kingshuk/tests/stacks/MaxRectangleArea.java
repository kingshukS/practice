package com.kingshuk.tests.stacks;

import static com.kingshuk.tests.stacks.MaxAreaOfHistogramEfficient.findMaxAreaEfficient;

public class MaxRectangleArea {
    public static void main ( String[] args ) {
        int R = 4;
        int C = 4;

        int[][] A = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.print ( "Area of maximum rectangle is "
                + maxRectangle ( R, C, A ) );
    }

    private static int maxRectangle ( int r, int c, int[][] a ) {
        int[] firstRow = a[0];
        int maxArea = findMaxAreaEfficient ( firstRow, c );
        for ( int i = 1; i < r; i++ ) {
            for ( int j = 0; j < c; j++ ) {
                if ( a[i][j] == 0 ) {
                    firstRow[j] = 0;
                } else {
                    firstRow[j] = firstRow[j] + a[i][j];
                }
            }
            maxArea = Math.max ( maxArea, findMaxAreaEfficient ( firstRow, c ) );
        }
        return maxArea;
    }
}
