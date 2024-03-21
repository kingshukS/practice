package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static void main ( String[] args ) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix ();
        System.out.println ( longestCommonPrefix.longestCommonPrefix ( new String[]{ "flower", "flow", "flight", "" } ) );
    }

    public String longestCommonPrefix ( String[] strs ) {
        if ( strs.length == 0 ) return "";
        String prefix = strs[0];
        for ( int i = 1; i < strs.length; i++ ) {
            while (strs[i].indexOf ( prefix ) != 0)
                prefix = prefix.substring ( 0, prefix.length () - 1 );
        }
        return prefix;
    }

    public String longestCommonPrefix2 ( String[] strs ) {
        String prefix = strs[0];
        int count = 1;

        while (count < strs.length) {
            if ( strs[count].indexOf ( prefix ) != 0 ) {
                prefix = prefix.substring ( 0, prefix.length () - 1 );
            } else {
                count++;
            }
        }
        return prefix;
    }
}
