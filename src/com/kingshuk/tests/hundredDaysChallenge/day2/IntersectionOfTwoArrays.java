package com.kingshuk.tests.hundredDaysChallenge.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
        Arrays.stream(intersection).forEach(i -> System.out.println(i+" "));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for(int i = 0; i<nums2.length; i++)
            set.add(nums2[i]);
        for(int i = 0; i<nums1.length; i++){
            if(set.contains(nums1[i]))
                intersection.add(nums1[i]);
        }
        int index = 0;
        int[] result = new int[intersection.size()];
        for(Integer i : intersection ){
            result[index++] = i;
        }
        return result;
    }
}
