package com.kingshuk.tests.hundredDaysChallenge.day17;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences ( int[] arr ) {
        int[] count = new int[2000];
        for ( int num : arr )
            count[num + 1000]++;
        Set<Integer> set = new HashSet<> ();
        for ( int i = 0; i < 2000; i++ ) {
            if ( count[i] > 0 && ! set.add ( count[i] ) ) {
                return false;
            }
        }
        return true;
    }
}
