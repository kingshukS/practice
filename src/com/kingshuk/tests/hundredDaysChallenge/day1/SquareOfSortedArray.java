package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquareOfSortedArray {
    public static void main ( String[] args ) {
        int[] arr = { - 4, - 1, 0, 3, 10 };
        int[] result = findSortedSquareArray ( arr );
        Arrays.stream ( result ).forEach ( System.out::println );
    }

    private static int[] findSortedSquareArray ( int[] arr ) {
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        for ( int i = arr.length - 1; i >= 0; i-- ) {
            int sqA = arr[start] * arr[start];
            int sqB = arr[end] * arr[end];
            if ( sqA > sqB ) {
                result[i] = sqA;
                start++;
            } else {
                result[i] = sqB;
                end--;
            }
        }
        return result;
    }
}
