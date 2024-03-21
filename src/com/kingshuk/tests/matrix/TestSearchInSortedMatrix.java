package com.kingshuk.tests.matrix;

public class TestSearchInSortedMatrix {
    public static void main ( String[] args ) {
        int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 34, 39, 50 } };
        printAndFindInSortedMatrix ( matrix, 34 );
    }

    private static void printAndFindInSortedMatrix ( int[][] matrix, int x ) {
        int k = 0, m = matrix.length, n = matrix[0].length, l = n - 1;
        while (k < m && l >= 0) {
            if ( matrix[k][l] == x ) {
                System.out.println ( "Position: row=" + ( k + 1 ) + " col=" + ( l + 1 ) );
                return;
            } else if ( x > matrix[k][l] ) {
                k++;
            } else {
                l--;
            }
        }
        System.out.println ( "Not found!!!!!!!!!!" );
    }
}
