package com.kingshuk.tests.Important;

import java.util.HashMap;

public class LongSubArrwithSumK {

    static int longestSubArraylength ( int[] arr, int k ) {
        HashMap<Integer, Integer> hm = new HashMap<> ();
        int sum = 0;
        int maxlen = 0;

        for ( int i = 0; i < arr.length; i++ ) {
            sum += arr[i];
            if ( sum == k ) {
                maxlen = i + 1;
            }

            if ( ! hm.containsKey ( sum ) ) {
                hm.put ( sum, i );
            }

            if ( hm.containsKey ( sum - k ) ) {
                if ( maxlen < i - hm.get ( sum - k ) ) {
                    maxlen = i - hm.get ( sum - k );
                }
            }
        }
        return maxlen;
    }

    public static void main ( String[] args ) {
        int[] arr = { 15, - 2, 2, - 8, 1, 7, 10, 23 };
        int k = 0;
        System.out.print ( longestSubArraylength ( arr, k ) );
    }
}
