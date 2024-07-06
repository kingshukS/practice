package com.kingshuk.tests.striver.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue; // avoid duplicates
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && (nums[j] == nums[j - 1])) continue; // avoid duplicates
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while ((k < l) && (nums[k] == nums[k - 1])) k++; // avoid duplicates
                        while ((k < l) && (nums[l] == nums[l + 1])) l--; // avoid duplicates
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        fourSum(arr, -9).forEach(System.out::println);
    }
}