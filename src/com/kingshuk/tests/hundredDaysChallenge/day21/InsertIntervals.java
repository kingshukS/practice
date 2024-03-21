package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    /**
     * @param intervals   non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval
     *                    and intervals is sorted in ascending order by starti.
     * @param newInterval newInterval = [start, end] that represents the start and end of another interval.
     * @return intervals are still sorted in ascending order by starti and intervals still does not have any overlapping intervals
     * (merge overlapping intervals if necessary).
     */
    public int[][] insert ( int[][] intervals, int[] newInterval ) {

        List<int[]> result = new ArrayList<> ();

        // Iterate through all slots
        for ( int[] slot : intervals ) {

            // if newInterval before slot insert newInterval & update slot as new interval
            if ( newInterval[1] < slot[0] ) {
                result.add ( newInterval );
                newInterval = slot;
            }

            // if slot is lesser than new Interval insert slot
            else if ( slot[1] < newInterval[0] ) {
                result.add ( slot );
            }

            // if above conditions fail it's an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min ( newInterval[0], slot[0] );
                newInterval[1] = Math.max ( newInterval[1], slot[1] );
            }
        }

        // insert the last newInterval
        result.add ( newInterval );

        // convert to int[][] array
        return result.toArray ( new int[result.size ()][] );
    }

}
