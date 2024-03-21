package com.kingshuk.tests.JustPractice;

import java.util.Arrays;

public class Anagram {
    static int NO_OF_CHARS = 256;

    static boolean isAnagram ( String s1, String s2 ) {
        char[] str1 = s1.toCharArray ();
        char[] str2 = s2.toCharArray ();
        int[] count1 = new int[NO_OF_CHARS];
        Arrays.fill ( count1, 0 );

        if ( s1.length () != s2.length () ) {
            return false;
        }

        for ( int i = 0; i < str1.length; i++ ) {
            count1[str1[i]]++;
            count1[str2[i]]--;
        }

        for ( int i = 0; i < NO_OF_CHARS; i++ ) {
            if ( count1[i] != 0 ) {
                return false;
            }
        }

        return true;

    }

    public static void main ( String[] args ) {
        String s1 = "NEHAL";
        String s2 = "HALYN";
        if ( isAnagram ( s1, s2 ) ) {
            System.out.print ( "The strings are anagram" );
        } else {
            System.out.print ( "The strings are not anagram" );
        }
    }
}
