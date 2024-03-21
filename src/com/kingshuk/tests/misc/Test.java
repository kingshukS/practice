package com.kingshuk.tests.misc;

public class Test {

    public static void main ( String[] args ) {
        int a = 10;
        String s1 = Integer.toString ( a );
        int[] b = new int[26];
        for ( int i = 0; i < s1.length (); i++ )
            System.out.println ( ++ b[s1.charAt ( i ) - '0'] );
        for ( int i = 0; i < b.length; i++ ) {
            System.out.println ( b[i] );
        }
    }

}
