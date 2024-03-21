package com.kingshuk.tests.misc;

public class TestCelebrityProblem {
    public static void main ( String[] args ) {
        int[][] MATRIX = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 1, 0 } };
        int celeb = findCelebrity ( MATRIX, MATRIX.length );
        if ( celeb != - 1 ) {
            System.out.println ( "Celebrity is:" + celeb );
        } else {
            System.out.println ( "No Celebrity Present at the Party" );
        }
    }

    private static int findCelebrity ( int[][] matrix, int n ) {
        int a = 0;
        int b = n - 1;
        int candidate = - 1;

        while (a <= b) {
            if ( matrix[a][b] == 1 ) {
                candidate = b;
                a++;
            } else {
                candidate = a;
                b--;
            }
        }

        for ( int i = 0; i < n; i++ ) {
            if ( candidate != i && matrix[i][candidate] == 0 || matrix[candidate][i] == 1 ) {
                return - 1;
            }
        }
        return candidate;
    }
}
