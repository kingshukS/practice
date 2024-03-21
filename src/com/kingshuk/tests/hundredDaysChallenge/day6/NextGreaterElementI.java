package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void nextGreaterElement ( int[] nums1, int[] nums2 ) {
        Map<Integer, Integer> map = new HashMap<> ();
        Stack<Integer> stack = new Stack<> ();
        for ( int num : nums2 ) {
            while (! stack.isEmpty () && stack.peek () < num)
                map.put ( stack.pop (), num );
            stack.push ( num );
        }
        for ( int i = 0; i < nums1.length; i++ ) {
            nums1[i] = map.getOrDefault ( nums1[i], - 1 );
        }
    }

    public static void main ( String[] args ) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        nextGreaterElement ( nums1, nums2 );
        Arrays.stream ( nums1 ).forEach ( System.out::println );
    }

}
