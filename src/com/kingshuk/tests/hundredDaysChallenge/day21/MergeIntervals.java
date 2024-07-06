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

    public int[][] mergeUsingScale(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }
        int[] range = new int[max - min + 1];
        for (int[] interval : intervals) {
            range[interval[0] - min] = Math.max(range[interval[0] - min], interval[1] - min);
        }
        int start = 0, end = 0;
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0)
                continue;
            if (i <= end)
                end = Math.max(end, range[i]);
            else {
                res.add(new int[]{start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        res.add(new int[]{start + min, end + min});
        return res.toArray(new int[res.size()][]);
    }

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

            // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
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
