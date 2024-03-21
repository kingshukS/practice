package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class FirstUniqueCharacter {
    public int firstUniqueChar ( String s ) {
        if ( s.length () == 0 )
            return - 1;
        if ( s.length () == 1 )
            return 0;
        int[] count = new int[26];
        for ( int i = 0; i < s.length (); i++ ) {
            count[s.charAt ( i ) - 'a']++;
        }
        int minIndex = Integer.MAX_VALUE;
        for ( int i = 0; i < 26; i++ ) {
            if ( count[i] == 1 ) {
                minIndex = Math.min ( minIndex, s.indexOf ( i + 'a' ) );
            }
        }
        return minIndex == Integer.MAX_VALUE ? - 1 : minIndex;
    }
}
