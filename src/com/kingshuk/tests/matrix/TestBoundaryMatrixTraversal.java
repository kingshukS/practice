package com.kingshuk.tests.matrix;

public class TestBoundaryMatrixTraversal {
    public static void main ( String[] args ) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrixBoundaryPattern ( matrix );
    }

    private static void printMatrixBoundaryPattern ( int[][] matrix ) {
        int m = matrix.length, n = matrix[0].length, i = 0;
        if ( m == 1 ) {
            for ( i = 0; i < n; i++ )
                System.out.print ( matrix[0][i] + " " );
        } else if ( n == 1 ) {
            for ( i = 0; i < m; i++ )
                System.out.print ( matrix[i][0] + " " );
        } else {
            for ( i = 0; i < n; i++ )
                System.out.print ( matrix[0][i] + " " );

            for ( i = 1; i < m; i++ )
                System.out.print ( matrix[i][n - 1] + " " );
            n--;

            for ( i = n - 1; i >= 0; i-- )
                System.out.print ( matrix[m - 1][i] + " " );
            m--;

            for ( i = m - 1; i >= 1; i-- )
                System.out.print ( matrix[i][0] + " " );
        }
    }
}
