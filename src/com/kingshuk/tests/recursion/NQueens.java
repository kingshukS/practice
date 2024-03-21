package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {

    public static void main ( String[] args ) {
        List<List<String>> ans = new NQueens ().solveNQueens ( 4 );
        System.out.println ( ans );
    }

    public List<List<String>> solveNQueens ( int n ) {
        List<List<String>> ans = new ArrayList<> ();
        char[][] emptyBoard = new char[n][n];
        for ( char[] row : emptyBoard ) {
            Arrays.fill ( row, '.' );
        }
        //backtrack(0, emptyBoard, ans, n);

        int[] rowHash = new int[n];
        int[] upperDiagonalHash = new int[2 * n - 1];
        int[] lowerDiagonalHash = new int[2 * n - 1];

        backtrack2 ( 0, emptyBoard, ans, n, rowHash, upperDiagonalHash, lowerDiagonalHash );
        return ans;
    }

    private void backtrack2 ( int col, char[][] emptyBoard, List<List<String>> ans, int n, int[] rowHash, int[] upperDiagonalHash, int[] lowerDiagonalHash ) {
        if ( col == n ) {
            ans.add ( addToAnswer ( emptyBoard ) );
            return;
        }
        for ( int i = 0; i < n; i++ ) {
            if ( rowHash[i] == 1 || upperDiagonalHash[n - 1 - col + i] == 1 || lowerDiagonalHash[i + col] == 1 )
                continue;

            emptyBoard[i][col] = 'Q';
            rowHash[i] = 1;
            upperDiagonalHash[n - 1 - col + i] = 1;
            lowerDiagonalHash[i + col] = 1;
            backtrack2 ( col + 1, emptyBoard, ans, n, rowHash, upperDiagonalHash, lowerDiagonalHash );
            emptyBoard[i][col] = '.';
            rowHash[i] = 0;
            upperDiagonalHash[n - 1 - col + i] = 0;
            lowerDiagonalHash[i + col] = 0;
        }
    }

    private List<String> addToAnswer ( char[][] emptyBoard ) {
        List<String> res = new ArrayList<> ();
        for ( char[] row : emptyBoard ) {
            String s = new String ( row );
            res.add ( s );
        }
        return res;
    }

    private void backtrack ( int col, char[][] emptyBoard, List<List<String>> ans, int n ) {
        if ( col == n ) {
            ans.add ( addToAnswer ( emptyBoard ) );
            return;
        }
        for ( int i = 0; i < n; i++ ) {
            if ( isSafe ( emptyBoard, i, col, n ) ) {
                emptyBoard[i][col] = 'Q';
                backtrack ( col + 1, emptyBoard, ans, n );
                emptyBoard[i][col] = '.';
            }
        }
    }

    private boolean isSafe ( char[][] emptyBoard, int row, int col, int n ) {
        int rowX = row, colX = col;
        while (col >= 0) {
            if ( emptyBoard[row][col] == 'Q' ) return false;
            col--;
        }

        row = rowX;
        col = colX;

        while (row >= 0 && col >= 0) {
            if ( emptyBoard[row][col] == 'Q' ) return false;
            row = row - 1;
            col = col - 1;
        }

        row = rowX;
        col = colX;
        while (row < n && col >= 0) {
            if ( emptyBoard[row][col] == 'Q' ) return false;
            row = row + 1;
            col = col - 1;
        }
        return true;
    }
}