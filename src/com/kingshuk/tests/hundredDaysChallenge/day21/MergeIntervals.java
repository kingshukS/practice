package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        Arrays.stream(new MergeIntervals().mergeUsingScale(new int[][]{{7, 9}, {6, 10}, {4, 5}, {1, 3}, {2, 4}}))
                .forEach(a -> System.out.println("{" + a[0] + "," + a[1] + "}"));
    }

    // Skipping it
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 1;
        while (i < intervals.length) {
            int[] first = intervals[i - 1];
            int[] second = intervals[i];
            if (second[0] <= first[1]) {
                intervals[i][0] = Math.min(first[0], second[0]);
                intervals[i][1] = Math.max(first[1], second[1]);
                intervals[i - 1][0] = -1;
            }
        }
        intervals = Arrays.stream(intervals).filter(arr -> arr[0] != -1).toArray(int[][]::new);
        return intervals;
    }

    /**
     * Merge intervals using a discrete scale based on start times.
     *
     * <p>Constructs a scale from the minimum to maximum start value and maps each
     * start index to the maximum end (offset by {@code minStart}). It then scans
     * the scale to merge consecutive or overlapping ranges into final intervals.</p>
     *
     * @param intervals an array of intervals where each interval is an {@code int[2]}
     *                  with {@code intervals[i][0]} as start and {@code intervals[i][1]} as end
     * @return a new array of merged intervals; returns an empty array if {@code intervals} is empty
     * @throws IllegalArgumentException if {@code intervals} is {@code null}
     */
    public int[][] mergeUsingScale(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int maxStart = Integer.MIN_VALUE;
        int minStart = Integer.MAX_VALUE;
        for (int[] interval : intervals) {
            minStart = Math.min(minStart, interval[0]);
            maxStart = Math.max(maxStart, interval[0]);
        }
        int[] range = new int[maxStart - minStart + 1];
        for (int[] interval : intervals) {
            range[interval[0] - minStart] = Math.max(range[interval[0] - minStart], interval[1] - minStart);
        }
        int start = 0, end = 0;
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0)
                continue;
            if (i <= end)
                end = Math.max(end, range[i]);
            else {
                res.add(new int[]{start + minStart, end + minStart});
                start = i;
                end = range[i];
            }
        }
        res.add(new int[]{start + minStart, end + minStart});
        return res.toArray(new int[res.size()][]);
    }

    /**
     * Merge overlapping intervals.
     *
     * <p>Sorts the input intervals by start time and merges any overlapping or adjacent
     * intervals into a single interval.</p>
     *
     * @param intervals an array of intervals where each interval is an {@code int[2]}
     *                  with {@code intervals[i][0]} as start and {@code intervals[i][1]} as end
     * @return a new array of merged intervals
     * @throws IllegalArgumentException if {@code intervals} is {@code null}
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        // Iterate through all slots
        int[] newInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] slot = intervals[i];
            // if newInterval before slot insert newInterval & update slot as new interval
            if (newInterval[1] < slot[0]) {
                result.add(newInterval);
                newInterval = slot;
            }

            // if slot is lesser than new Interval insert slot
            else if (slot[1] < newInterval[0]) {
                result.add(slot);
            }

            // if above conditions fail it's an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        // insert the last newInterval
        result.add(newInterval);

        // convert to int[][] array
        return result.toArray(new int[result.size()][]);
    }
}
