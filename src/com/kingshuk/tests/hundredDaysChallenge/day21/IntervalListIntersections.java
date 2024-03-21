package com.kingshuk.tests.hundredDaysChallenge.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main ( String[] args ) {
        int[][] firstIntervalList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondIntervalList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        Arrays.stream ( new IntervalListIntersections ().intervalIntersection ( firstIntervalList, secondIntervalList ) ).forEach ( a -> System.out.println ( "{" + a[0] + "," + a[1] + "}" ) );
    }

    public int[][] intervalIntersection ( int[][] firstList, int[][] secondList ) {
        if ( firstList.length == 0 || secondList.length == 0 )
            return new int[0][];
        int i = 0, j = 0;
        List<int[]> resultList = new ArrayList<> ();
        while (i < firstList.length && j < secondList.length) {
            if ( firstList[i][1] < secondList[j][0] ) {
                i++;
            } else if ( firstList[i][0] > secondList[j][1] ) {
                j++;
            } else {
                resultList.add ( new int[]{ Math.max ( firstList[i][0], secondList[j][0] ), Math.min ( firstList[i][1], secondList[j][1] ) } );
                if ( firstList[i][1] <= secondList[j][1] )
                    i++;
                else
                    j++;
            }
        }
        return resultList.toArray ( new int[resultList.size ()][] );
    }
}
