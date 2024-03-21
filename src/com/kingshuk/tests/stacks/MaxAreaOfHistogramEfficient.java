package com.kingshuk.tests.stacks;


import java.util.ArrayDeque;

public class MaxAreaOfHistogramEfficient {
    public static void main ( String[] args ) {
        int[] heights = { 6, 2, 5, 4, 5, 1, 6 };
        int maxArea = findMaxAreaEfficient ( heights, heights.length );
        System.out.println ( "Max area of a histogram: " + maxArea );
    }

    public static int findMaxAreaEfficient ( int[] heights, int n ) {
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        for ( int i = 0; i < heights.length; i++ ) {
            while (! stack.isEmpty () && heights[i] < heights[stack.peek ()]) {
                int t = stack.pop ();
                int current = heights[t] * ( stack.isEmpty () ? i : ( i - stack.peek () - 1 ) );
                maxArea = Math.max ( maxArea, current );
            }
            stack.push ( i );
        }
        while (! stack.isEmpty ()) {
            int t = stack.pop ();
            int current = heights[t] * ( stack.isEmpty () ? n : ( n - stack.peek () - 1 ) );
            maxArea = Math.max ( maxArea, current );
        }
        return maxArea;
    }
}
