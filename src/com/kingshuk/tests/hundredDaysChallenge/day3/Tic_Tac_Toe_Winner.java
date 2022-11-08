package com.kingshuk.tests.hundredDaysChallenge.day3;

public class Tic_Tac_Toe_Winner {
    public static void main(String[] args) {
        int[][] moves = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        int n = 3;
        String winner = findTicTacToeWinner(moves, n);
        System.out.println("Result: " + winner);
    }

    private static String findTicTacToeWinner(int[][] moves, int n) {
        if (moves.length <= (n - 1) * 2)
            return "PENDING";
        char[][] board = new char[n][n];
        for (int i = 0; i < (n - 1) * 2; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            if (i % 2 == 0) {
                board[row][col] = 'X';
            } else {
                board[row][col] = 'O';
            }
        }
        for (int i = (n - 1) * 2; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            char ch = 'X';
            if (i % 2 == 0) {
                board[row][col] = 'X';
            } else {
                board[row][col] = 'O';
                ch = 'O';
            }
            boolean won = didWin(board,row, col, ch, n);
            if(won && ch == 'X')
                return "A WINS";
            else if(won)
                return "B WINS";
        }
        if(moves.length == n*n)
            return "DRAW";
        return "PENDING";
    }

    private static boolean didWin(char[][] board, int row, int col, char ch, int n) {
        //row-wise check
        boolean didWin = true;
        int i;
        for(i = 0; i<n; i++ ){
            if(board[row][i] != ch) {
                didWin = false;
                break;
            }
        }
        if(didWin)
            return true;

        //col-wise check
        didWin = true;
        for(i = 0; i<n; i++ ){
            if(board[i][col] != ch) {
                didWin = false;
                break;
            }
        }
        if(didWin)
            return true;

        //diagonal check
        if(row == col){
            didWin = true;
            for(i = 0; i<n; i++ ){
                if(board[i][i] != ch) {
                    didWin = false;
                    break;
                }
            }
            if(didWin)
                return true;
        }
        //reverse diagonal check
        if(col == n-row-1){
            didWin = true;
            for(i = 0; i<n; i++ ){
                if(board[i][n-i-1] != ch) {
                    didWin = false;
                    break;
                }
            }
            return didWin;
        }
        return false;
    }
}
