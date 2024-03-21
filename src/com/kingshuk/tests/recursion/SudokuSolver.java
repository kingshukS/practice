package com.kingshuk.tests.recursion;

class SudokuSolver {
    public void solveSudoku ( char[][] board ) {
        backtrack ( board, 0, board.length );
    }

    private boolean backtrack ( char[][] board, int startingRow, int n ) {
        for ( int i = startingRow; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( board[i][j] == '.' ) {
                    for ( char c = '1'; c <= '9'; c++ ) {
                        if ( isSafe ( board, i, j, c ) ) {
                            board[i][j] = c;
                            if ( backtrack ( board, i, n ) )
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe ( char[][] board, int row, int col, char c ) {
        int blockRow = 3 * ( row / 3 );
        int blockCol = 3 * ( col / 3 );
        for ( int i = 0; i < 9; i++ ) {
            if ( board[row][i] == c || board[i][col] == c || board[blockRow + i / 3][blockCol + i % 3] == c )
                return false;
        }
        return true;
    }
}