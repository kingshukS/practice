package com.kingshuk.tests.hundredDaysChallenge.day27;

import java.util.Stack;

class DecodeString {
    public static void main ( String[] args ) {
        System.out.println ( new DecodeString ().decodeString ( "2[a3[c2[x]]y]" ) );
    }

    public String decodeString ( String s ) {
        Stack<Integer> counts = new Stack ();
        Stack<String> results = new Stack ();
        int num = 0;
        for ( char c : s.toCharArray () ) {
            if ( Character.isDigit ( c ) ) {
                num = num * 10 + ( c - '0' );

            } else if ( c == '[' ) {
                counts.push ( num );
                num = 0;
                results.push ( String.valueOf ( c ) );
            } else if ( c == ']' ) {
                StringBuilder sb = new StringBuilder ();
                while (! results.peek ().equals ( "[" ))
                    sb.append ( results.pop () );
                results.pop ();
                int count = counts.pop ();
                StringBuilder s1 = new StringBuilder ();
                for ( int i = 0; i < count; i++ )
                    s1.append ( sb );
                results.push ( s1.toString () );
            } else {
                results.push ( String.valueOf ( c ) );
            }
        }
        StringBuilder stringBuilder = new StringBuilder ( results.pop () );
        while (! results.isEmpty ())
            stringBuilder.append ( results.pop () );
        return stringBuilder.reverse ().toString ();
    }
}