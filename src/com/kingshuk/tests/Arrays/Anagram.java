package com.kingshuk.tests.Arrays;

import java.util.Arrays;

public class Anagram {
        static int NO_OF_CHARS = 256;

        public static void main ( String[] args ) {
            char[] str1 = ( "TRIANGLE" ).toCharArray ();
            char[] str2 = ( "INTEKRAL" ).toCharArray ();
            if ( isAnagram ( str1, str2 ) ) {
                System.out.println ( "yes" );
            } else
                System.out.println ( "no" );
        }

        static boolean isAnagram ( char[] str1, char[] str2 ) {
            int[] count1 = new int[NO_OF_CHARS];
            Arrays.fill ( count1, 0 );
            int i;

            // For each character in input strings, increment count in
            // the corresponding count array
            for ( i = 0; i < str1.length && i < str2.length; i++ ) {
                count1[str1[i]]++;
                count1[str2[i]]--;
            }

            // If both strings are of different length. Removing this condition
            // will make the program fail for strings like "aaca" and "aca"
            if ( str1.length != str2.length )
                return false;

            // See if there is any non-zero value in count array
            for ( i = 0; i < NO_OF_CHARS; i++ )
                if ( count1[i] != 0 )
                    return false;
            return true;
        }
    }