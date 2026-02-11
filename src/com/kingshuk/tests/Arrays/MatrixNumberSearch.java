package com.kingshuk.tests.Arrays;

public class MatrixNumberSearch {

        public static void main ( String[] args ) {
            int[][] mat = { { 10, 20, 30, 40 },
                    { 15, 25, 35, 45 },
                    { 27, 29, 37, 48 },
                    { 32, 33, 39, 50 } };
            searchElement ( mat, 4, 29 );
        }

        static void searchElement ( int[][] arr, int size, int num ) {
            int i = 0;
            int j = size - 1;
            while (i < size && j >= 0) {
                if ( arr[i][j] == num ) {
                    System.out.println ( "Number found at position " + i + " " + j );
                    return;
                }

                if ( arr[i][j] > num ) {
                    j--;
                } else
                    i++;
            }
            System.out.print ( "n Element not found" );
        }
    }