package com.kingshuk.tests.hundredDaysChallenge.day20;

import com.kingshuk.tests.sorting.LomutoPartition;

import java.util.*;


/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && (nums[i] == nums[i-1])) continue;
            for(int j = i+1, k = nums.length-1; j<k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    return target;
                }else if(sum > target) {
                    int diff = sum - target;
                    if(diff < Math.abs(result-target))
                        result = sum;
                    k--;
                }
                else {
                    int diff = target-sum;
                    if(diff < Math.abs(result-target))
                        result = sum;
                    j++;
                }
            }
        }
        return result;
    }
}
