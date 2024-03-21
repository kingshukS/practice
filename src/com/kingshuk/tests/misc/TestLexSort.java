package com.kingshuk.tests.misc;

import java.util.ArrayList;
import java.util.Collections;

public class TestLexSort {
    public static void main ( String[] args ) {
        System.out.println ( LexSort.powerSet ( "abc" ) );
    }
}

class LexSort {
    static ArrayList<String> list = new ArrayList<> ();

    //Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet ( String s ) {
        // add your code here
        powerSetString ( s, 0, "" );
        Collections.sort ( list );
        return list;
    }

    static void powerSetString ( String s, int index, String curr ) {

        if ( s.length () == index ) {
            list.add ( curr );
            return;
        }
        powerSetString ( s, index + 1, curr );
        powerSetString ( s, index + 1, curr + s.charAt ( index ) );
    }
}
