package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{0,2},{1,3},{2,4},{3,5},{4,6}}));
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
}
