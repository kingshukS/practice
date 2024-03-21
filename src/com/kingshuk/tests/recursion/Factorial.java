package com.kingshuk.tests.recursion;

public class Factorial {
    public static void main ( String[] args ) {
        System.out.println ( findFactorial ( 5 ) );
        findFactorial ( 5, 1 );
    }

    // parameterized
    private static void findFactorial ( int n, int f ) {
        if ( n == 1 ) {
            System.out.println ( f );
            return;
        }
        findFactorial ( n - 1, f * n );
    }

    // functional
    private static int findFactorial ( int n ) {
        if ( n == 1 )
            return 1;
        return n * findFactorial ( n - 1 );
    }


}
