package com.kingshuk.tests.matrix;

public class TestTransposeMatrixTraversal {
    public static void main ( String[] args ) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrix ( matrix );
        convertToTransposeMatrixPattern ( matrix );
        System.out.println ( "Transpose matrix:" );
        printMatrix ( matrix );
    }

    private static void printMatrix ( int[][] matrix ) {
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                System.out.print ( matrix[i][j] + " " );
            }
            System.out.println ();
        }
    }

    private static void convertToTransposeMatrixPattern ( int[][] matrix ) {
        int rows = matrix.length;
        int i = 0, c = 0;
        while (i < rows) {
            for ( c = i + 1; c < matrix[i].length; c++ ) {
                int temp = matrix[i][c];
                matrix[i][c] = matrix[c][i];
                matrix[c][i] = temp;
            }
            i++;
        }
    }
}
