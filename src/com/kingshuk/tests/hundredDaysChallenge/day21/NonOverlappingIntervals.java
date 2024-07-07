package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make
 * the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {
    public static void main ( String[] args ) {
        System.out.println ( new NonOverlappingIntervals ().eraseOverlapIntervalsUsingScale ( new int[][]{ { 0, 2 }, { 1, 3 }, { 4, 4 }, { 3, 5 }, { 4, 6 } } ) );
    }

    public int eraseOverlapIntervals ( int[][] intervals ) {
        if ( intervals.length <= 1 )
            return 0;
        Arrays.sort ( intervals, Comparator.comparingInt ( a -> a[1] ) );
        int i = 1;
        int j = 0;
        int count = 0;
        while (i < intervals.length) {
            if ( intervals[i][0] >= intervals[j][1] ) {
                count++;
                j = i;
            }
            i++;
        }
        return intervals.length - count;
    }

    public int eraseOverlapIntervalsUsingScale ( int[][] intervals ) {
        int n = intervals.length;
        if ( n <= 1 )
            return 0;
        int maxEnd = Integer.MIN_VALUE;
        int minEnd = Integer.MAX_VALUE;
        for ( int[] in : intervals ) {
            maxEnd = Math.max ( maxEnd, in[1] );
            minEnd = Math.min ( minEnd, in[1] );
        }
        Integer[] range = new Integer[maxEnd - minEnd + 1];
        for ( int[] interval : intervals ) {
            int start = interval[0] - minEnd;
            int end = interval[1] - minEnd;
            // maximize the starting time for a range ending
            if ( range[end] == null || start > range[end] ) {
                range[end] = start;
            }
        }
        int count = 1, priorEnd = 0;
        for ( int i = 0; i < range.length; i++ ) {
            if ( range[i] == null || range[i] < priorEnd )
                continue;
            count++;
            priorEnd = i;
        }
        return n - count;
    }
}
