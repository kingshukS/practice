package com.kingshuk.tests.misc;

import java.util.ArrayList;
import java.util.Collections;

public class TestWordsFromPhoneDigits {
    static String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static ArrayList<String> list = new ArrayList<> ();

    public static void main ( String[] args ) {
        int[] a = { 5, 8, 8, 9, 8 };
        getAllStrings ( a, a.length );
        System.out.println ( list );
    }

    private static void getAllStrings ( int[] a, int n ) {
        getString ( a, 0, n, "" );
        Collections.sort ( list );
    }

    private static void getString ( int[] a, int l, int n, String c ) {
        if ( l == n ) {
            list.add ( c );
            return;
        }
        int k = a[l];
        String s = keypad[k - 2];
        for ( int i = 0; i < s.length (); i++ ) {
            char ch = s.charAt ( i );
            String s1 = c + ch;
            getString ( a, l + 1, n, s1 );
        }
    }
}
