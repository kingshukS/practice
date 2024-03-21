package com.kingshuk.tests.hundredDaysChallenge.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class ContiguousArray {
    public static void main ( String[] args ) {
        System.out.println ( new ContiguousArray ().findMaxLength ( new int[]{ 0, 0, 1, 0, 0, 0, 1, 1 } ) );
    }

    public int findMaxLength ( int[] arr ) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<> ();
        map.put ( 0, - 1 );
        int count = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( arr[i] == 0 )
                count -= 1;
            else count += 1;

            if ( map.get ( count ) != null )
                maxLength = Math.max ( maxLength, i - map.get ( count ) );
            else
                map.put ( count, i );
        }
        return maxLength;
    }
}
