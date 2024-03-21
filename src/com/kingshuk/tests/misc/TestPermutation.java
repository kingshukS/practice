package com.kingshuk.tests.misc;

public class TestPermutation {
    public static void main ( String[] args ) {
        String s = "ABCD";
        printAllPermutation ( s, 0, s.length () - 1 );
    }

    private static void printAllPermutation ( String s, int l, int r ) {
        if ( l == r )
            System.out.println ( s );
        else {
            for ( int i = l; i <= r; i++ ) {
                s = swap ( s, l, i );
                printAllPermutation ( s, l + 1, r );
                s = swap ( s, l, i );
            }
        }
    }

    private static String swap ( String s, int l, int i ) {
        char temp;
        char[] chars = s.toCharArray ();
        temp = chars[l];
        chars[l] = chars[i];
        chars[i] = temp;

        return String.valueOf ( chars );
    }
}
