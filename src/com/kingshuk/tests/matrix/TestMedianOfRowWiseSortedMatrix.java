package com.kingshuk.tests.matrix;

import java.util.Arrays;

public class TestMedianOfRowWiseSortedMatrix {
    public static void main ( String[] args ) {
        int[][] matrix = { { 5, 10, 20, 30, 40 }, { 1, 2, 3, 4, 6 }, { 11, 13, 15, 17, 19 } };
        printAndFindMedianOfRowWiseSortedMatrix ( matrix );
    }

    private static void printAndFindMedianOfRowWiseSortedMatrix ( int[][] matrix ) {
        int m = matrix.length, n = matrix[0].length, min = matrix[0][0], max = matrix[0][n - 1];

        // find min and max of the row-wise sorted matrix

        for ( int i = 1; i < m; i++ ) {
            min = Math.min ( min, matrix[i][0] );
            max = Math.max ( max, matrix[i][n - 1] );
        }
        int medPos = ( m * n + 1 ) / 2;

        while (min < max) {
            int mid = ( min + max ) / 2, midPos = 0;
            for ( int i = 0; i < m; i++ ) {
                int pos = Arrays.binarySearch ( matrix[i], mid ) + 1;
                midPos += Math.abs ( pos );
            }
            if ( midPos < medPos )
                min = mid + 1;
            else
                max = mid;
        }
        System.out.println ( "Median Element=" + min );
    }
}
