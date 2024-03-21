package com.kingshuk.tests.matrix;

public class TestRotateNinetyDegreeMatrixTraversal {
    public static void main ( String[] args ) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrix ( matrix );
        convertToTransposeMatrixPattern ( matrix );
        System.out.println ( "Transpose matrix:" );
        printMatrix ( matrix );
        reverseColumns ( matrix );
        System.out.println ( "Rotated matrix:" );
        printMatrix ( matrix );
    }

    private static void reverseColumns ( int[][] matrix ) {
        int n = matrix[0].length;
        for ( int i = 0; i < n; i++ ) {
            int low = 0;
            int high = matrix.length - 1;
            while (low < high) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
                low++;
                high--;
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
