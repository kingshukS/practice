package com.kingshuk.tests.hundredDaysChallenge.day23;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, curSum = 0, removeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            removeSum = curSum - k;
            if (map.containsKey(removeSum))
                result += map.get(removeSum);

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }
}
