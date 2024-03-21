package com.kingshuk.tests.hundredDaysChallenge.day11;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {
    public static void main ( String[] args ) {
        IsSubsequence isSubsequence = new IsSubsequence ();
        System.out.println ( isSubsequence.isSubsequence2 ( "k", "ahbgdc", 0, 0 ) );
    }

    public boolean isSubsequence ( String s, String t ) {
        if ( s.length () == 0 )
            return true;
        if ( t.length () == 0 )
            return false;
        if ( s.charAt ( 0 ) == t.charAt ( 0 ) )
            return isSubsequence ( s.substring ( 1 ), t.substring ( 1 ) );
        else
            return isSubsequence ( s, t.substring ( 1 ) );
    }

    public boolean isSubsequenceNew ( String s, String t ) {
        int j = 0;
        for ( int i = 0; i < t.length () && j < s.length (); i++ ) {
            if ( s.charAt ( j ) == t.charAt ( i ) )
                j++;
        }
        return ( j == s.length () );
    }

    public boolean isSubsequence2 ( String s, String t, int i, int j ) {
        if ( i == s.length () )
            return true;
        if ( j == t.length () )
            return false;
        if ( s.charAt ( i ) == t.charAt ( j ) )
            return isSubsequence2 ( s, t, i + 1, j + 1 );
        else
            return isSubsequence2 ( s, t, i, j + 1 );
    }
}
