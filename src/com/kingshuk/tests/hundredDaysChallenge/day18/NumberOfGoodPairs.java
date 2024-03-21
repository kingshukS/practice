package com.kingshuk.tests.hundredDaysChallenge.day18;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 * <p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
public class NumberOfGoodPairs {
    public static void main ( String[] args ) {
        System.out.println ( new NumberOfGoodPairs ().numIdenticalPairs ( new int[]{ 1, 2, 3 } ) );
    }

    public int numIdenticalPairs ( int[] nums ) {
        Map<Integer, Integer> map = new HashMap<> ();
        int count = 0;
        for ( int num : nums ) {
            count += map.getOrDefault ( num, 0 );
            map.put ( num, map.getOrDefault ( num, 0 ) + 1 );
        }
        return count;
    }
}
