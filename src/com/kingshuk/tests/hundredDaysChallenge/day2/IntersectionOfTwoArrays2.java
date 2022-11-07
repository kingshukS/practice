package com.kingshuk.tests.hundredDaysChallenge.day2;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays, and you may return the result in any order.
 */
public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
        Arrays.stream(intersection).forEach(i -> System.out.print(i+" "));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for(int i = 0; i<nums2.length; i++) {
            if(set.containsKey(nums2[i]))
                set.put(nums2[i], set.get(nums2[i])+1);
            else
                set.put(nums2[i],1);
        }
        for(int i = 0; i<nums1.length; i++){
            if(set.containsKey(nums1[i]) && set.get(nums1[i]) > 0) {
                intersection.add(nums1[i]);
                set.put(nums1[i], set.get(nums1[i]) - 1);
            }
        }
        int index = 0;
        int[] result = new int[intersection.size()];
        for(Integer i : intersection ){
            result[index++] = i;
        }
        return result;
    }
}
