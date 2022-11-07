package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 20;
        findAndPrintTwoSumIndex(arr, target);
    }

    private static void findAndPrintTwoSumIndex(int[] arr, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(valueIndexMap.containsKey(target-arr[i]))
            {
                System.out.print("["+valueIndexMap.get(target-arr[i]));
                System.out.println(","+i+"]");
                return;
            }
            valueIndexMap.put(arr[i], i);
        }
        System.out.println("Not found");
    }
}
