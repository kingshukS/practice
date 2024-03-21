package com.kingshuk.tests.hundredDaysChallenge.day24;

/**
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 * <p>
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them,
 * the result should equal the sorted array.
 * <p>
 * Return the largest number of chunks we can make to sort the array.
 */

/**
 * Just an explanation for who may get confused how this works:
 * For this question, what this algorithm wants us to do is finding some splitting line so that numbers being left of this line are all smaller than
 * numbers right of this line.
 * The idea is very similar to quick sort. What the answer of this question is how many lines you can find. So that is why we want the max array,
 * or we can only need a number for storing the maximum number up to now(because original array is 0 to len-1), as long as the max number equals
 * the index, we know that all numbers left to this point are smaller than this point and numbers right to this point are larger than this point,
 * then we count add one.
 */
public class MaxChunkToSorted {
    public int maxChunksToSorted ( int[] arr ) {
        int count = 0;
        int max = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            max = Math.max ( max, arr[i] );
            if ( max == i )
                count++;
        }
        return count;
    }
}
