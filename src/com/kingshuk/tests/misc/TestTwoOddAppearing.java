package com.kingshuk.tests.misc;

public class TestTwoOddAppearing {
    public static void main ( String[] args ) {
        int[] arr = { 3, 2, 4, 5, 4, 4, 4, 5, 2, 0, 0, 5 };
        int xor = 0;
        for ( int i = 0; i < arr.length; i++ )
            xor = xor ^ arr[i];
        int sn = xor & ~ ( xor - 1 );
        int res1 = 0, res2 = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( ( arr[i] & sn ) == 0 )
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }
        System.out.println ( res1 + "    " + res2 );
    }
}
