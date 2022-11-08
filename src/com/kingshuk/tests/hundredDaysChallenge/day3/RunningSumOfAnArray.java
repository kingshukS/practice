package com.kingshuk.tests.hundredDaysChallenge.day3;

import java.util.Arrays;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class RunningSumOfAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res = findRunningSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findRunningSum(int[] arr) {
        if(arr.length == 0 || arr.length == 1)
            return arr;
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            res[i] = res[i-1] + arr[i];
        }
        return res;
    }
}
