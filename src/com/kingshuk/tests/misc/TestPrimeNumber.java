package com.kingshuk.tests.misc;

public class TestPrimeNumber {
    public static void main ( String[] args ) {
        int x = 121;
        System.out.println ( "Prime or Not :" + isPrimeNumber ( x ) );
    }

    private static boolean isPrimeNumber ( int n ) {
        if ( n == 1 )
            return false;
        if ( n == 2 || n == 3 ) {
            return true;
        }
        if ( n % 2 == 0 && n % 3 == 0 ) {
            return false;
        }
        for ( int i = 5; i * i <= n; i = i + 6 ) {
            if ( n % i == 0 || n % ( i + 2 ) == 0 ) {
                return false;
            }
        }
        return true;
    }
}
