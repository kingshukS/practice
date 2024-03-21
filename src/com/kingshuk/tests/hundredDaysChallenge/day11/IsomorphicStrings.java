package com.kingshuk.tests.hundredDaysChallenge.day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main ( String[] args ) {
        IsomorphicStrings isIsomorphic = new IsomorphicStrings ();
        System.out.println ( isIsomorphic.isIsomorphic ( "foo", "bar" ) );
    }

    public boolean isIsomorphic ( String s, String t ) {
        Map<Character, Character> charMapping = new HashMap<> ();
        Set<Character> usedCharSet = new HashSet<> ();
        for ( int i = 0; i < s.length (); i++ ) {
            char sChar = s.charAt ( i );
            char tChar = t.charAt ( i );
            if ( charMapping.containsKey ( sChar ) ) {
                if ( charMapping.get ( sChar ) != tChar ) {
                    return false;
                }
            } else {
                if ( usedCharSet.contains ( tChar ) )
                    return false;
                else {
                    usedCharSet.add ( tChar );
                    charMapping.put ( sChar, tChar );
                }
            }
        }
        return true;
    }
}
