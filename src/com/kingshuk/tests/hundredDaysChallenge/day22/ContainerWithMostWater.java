package com.kingshuk.tests.hundredDaysChallenge.day22;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea ( int[] height ) {
        int max = Integer.MIN_VALUE;
        for ( int i = 0, j = height.length - 1; i < j; ) {
            max = Math.max ( max, Math.min ( height[i], height[j] ) * ( j - i ) );
            if ( height[i] < height[j] )
                i++;
            else
                j--;
        }
        return max;
    }
}
