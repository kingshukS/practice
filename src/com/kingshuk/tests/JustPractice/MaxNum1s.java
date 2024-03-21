package com.kingshuk.tests.JustPractice;

public class MaxNum1s {

    static int max1s ( int[][] arr ) {
        int row = 0;
        int j = arr.length - 1;
        for ( int i = 0; i < arr.length; i++ ) {
            while (j >= 0 && arr[i][j] == 1) {
                j--;
                row = i;
            }
        }
        return row + 1;
    }

    public static void main ( String[] args ) {
        int[][] arr = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 0 } };
        System.out.print ( max1s ( arr ) );
    }
}
