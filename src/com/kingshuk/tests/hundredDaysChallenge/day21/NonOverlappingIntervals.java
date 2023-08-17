package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{0,2},{1,3},{4,4},{3,5},{4,6}}));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <=1)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int i = 1;
        int j = 0;
        int count = 0;
        while(i<intervals.length){
            if(intervals[i][0]< intervals[j][1]){
                count++;
            }else{
                j=i;
            }
            i++;
        }
        return count;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        int n = intervals.length;
        if(n<=1)
            return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] in : intervals){
            max = Math.max(max, in[1]);
            min = Math.min(min, in[1]);
        }
        Integer[] range = new Integer[max-min+1];
        for(int[] in : intervals){
            int s = in[0] - min;
            int e = in[1] - min;
            if(range[e] == null || s>range[e])
            {
                range[e] = s;
            }
        }
        int count = 1, priorEnd = 0;
        for(int i = 0; i<range.length; i++)
        {
            if(range[i] != null && range[i]>=priorEnd)
            {
                count++;
                priorEnd = i;
            }
        }
        return n - count;
    }
}
