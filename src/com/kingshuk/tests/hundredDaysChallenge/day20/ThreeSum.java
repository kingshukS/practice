package com.kingshuk.tests.hundredDaysChallenge.day20;

import com.kingshuk.tests.sorting.LomutoPartition;

import java.util.*;


/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and
 * nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i<nums.length-2; i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] == 0)
                {
                    if(!set.contains(""+nums[i]+nums[l]+nums[r])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        set.add(""+nums[i]+nums[l]+nums[r]);
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r] < 0)
                    l++;
                else
                    r--;
            }
        }
        return result;
    }

    private void quicksort(int[] nums, int l, int r) {
        if(l<r){
            int pi = partition(nums, l, r);
            quicksort(nums, l, pi-1);
            quicksort(nums, pi+1, r);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {

        return LomutoPartition.applyLomutoPartition(arr, lo, hi, hi);
    }

    public List<List<Integer>> threeSumBest(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
            for(int j = i+1, k = nums.length-1; j<k;) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
                    while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
                }else if(nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return list;
    }
}
