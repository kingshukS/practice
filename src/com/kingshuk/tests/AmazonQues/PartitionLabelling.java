package com.kingshuk.tests.AmazonQues;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabelling {
    static List<Integer> partitionLabels ( String s ) {
        final List<Integer> result = new ArrayList<> ();
        final int[] lastIndexOfChar = new int[26];
        for ( int i = 0; i < s.length (); i++ ) {
            lastIndexOfChar[s.charAt ( i ) - 'a'] = i; //storing last index of every character in the string
        }

        int beginIndex = 0;
        while (beginIndex < s.length ()) { //again going through every char
            int endIndex = lastIndexOfChar[s.charAt ( beginIndex ) - 'a'];
            //storing endIndex for char at begin index
            int j = beginIndex;
            //now checking for every char from j +1 (next char of a in first case)
            // till its last index and check whether any other char between first and last occurance
            // has ended after wards
            while (j != endIndex) {
                endIndex = Math.max ( lastIndexOfChar[s.charAt ( j++ ) - 'a'], endIndex );
                //finding out the max end index of chars lying

            }
            result.add ( j - beginIndex + 1 ); //adding the index.
            beginIndex = j + 1; //moving on to next character.
        }

        return result;
    }

    public static void main ( String[] args ) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels ( s );
        System.out.println ( list );
    }
}
