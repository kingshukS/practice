package com.kingshuk.tests.matrix;

public class TestSpiralMatrixTraversal {
    public static void main ( String[] args ) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrix ( matrix );
        System.out.println ( "Spiral matrix:" );
        printSpiralMatrix ( matrix );
    }

    private static void printSpiralMatrix ( int[][] matrix ) {
        int k = 0, l = 0, i = 0, m = matrix.length, n = matrix[0].length;
        while (k < m && l < n) {
            for ( i = l; i < n; i++ )
                System.out.print ( matrix[k][i] + " " );
            k++;

            for ( i = k; i < m; i++ )
                System.out.print ( matrix[i][n - 1] + " " );
            n--;

            if ( k <= m ) {
                for ( i = n - 1; i >= l; i-- )
                    System.out.print ( matrix[m - 1][i] + " " );
                m--;
            }

            if ( l <= n ) {
                for ( i = m - 1; i >= k; i-- )
                    System.out.print ( matrix[i][l] + " " );
                l++;
            }
        }
    }

    private static void printMatrix ( int[][] matrix ) {
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                System.out.print ( matrix[i][j] + " " );
            }
            System.out.println ();
        }
    }
}
