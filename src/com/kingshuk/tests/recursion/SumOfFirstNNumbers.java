package com.kingshuk.tests.recursion;

public class SumOfFirstNNumbers {
    public static void main ( String[] args ) {
        System.out.println ( sumOfFirstNNumbers ( 5 ) );
        sumOfFirstNNumbers ( 5, 0 );
    }

    // functional
    private static int sumOfFirstNNumbers ( int num ) {
        if ( num == 0 )
            return num;
        return num + sumOfFirstNNumbers ( num - 1 );
    }

    //parameterized
    private static void sumOfFirstNNumbers ( int num, int sum ) {
        if ( num == 0 ) {
            System.out.println ( sum );
            return;
        }
        sumOfFirstNNumbers ( num - 1, sum + num );
    }
}
