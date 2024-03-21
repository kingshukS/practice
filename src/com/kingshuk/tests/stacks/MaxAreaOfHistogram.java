package com.kingshuk.tests.stacks;


import java.util.ArrayDeque;

public class MaxAreaOfHistogram {
    public static void main ( String[] args ) {
        int[] heights = { 6, 2, 5, 4, 5, 1, 6 };
        int maxArea = findMaxArea ( heights );
        System.out.println ( "Max area of a histogram: " + maxArea );
    }

    private static int findMaxArea ( int[] heights ) {
        int[] left = findSmallerToLeft ( heights );
        int[] right = findSmallerToRight ( heights );
        int maxArea = 0;
        for ( int i = 0; i < heights.length; i++ ) {
            maxArea = Math.max ( maxArea, ( right[i] - left[i] + 1 ) * heights[i] );

        }
        return maxArea;
    }

    private static int[] findSmallerToRight ( int[] heights ) {
        int[] right = new int[heights.length];
        ArrayDeque<Integer> s = new ArrayDeque<> ();
        for ( int i = heights.length - 1; i >= 0; i-- ) {
            while (! s.isEmpty () && heights[i] <= heights[s.peek ()])
                s.pop ();
            if ( s.isEmpty () )
                right[i] = heights.length - 1;
            else
                right[i] = s.peek () - 1;
            s.push ( i );
        }
        return right;
    }

    private static int[] findSmallerToLeft ( int[] heights ) {
        int[] left = new int[heights.length];
        ArrayDeque<Integer> s = new ArrayDeque<> ();
        for ( int i = 0; i < heights.length; i++ ) {
            while (! s.isEmpty () && heights[i] <= heights[s.peek ()])
                s.pop ();
            if ( s.isEmpty () )
                left[i] = 0;
            else
                left[i] = s.peek () + 1;
            s.push ( i );
        }
        return left;
    }
}
