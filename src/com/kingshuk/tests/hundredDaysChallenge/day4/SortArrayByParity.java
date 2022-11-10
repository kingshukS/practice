package com.kingshuk.tests.hundredDaysChallenge.day4;

import java.util.Arrays;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        sortArrayByParity(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void sortArrayByParity(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i]%2==1)
                count++;
            else{
                int t = nums[i];
                nums[i] = nums[i-count];
                nums[i-count] = t;
            }
        }
    }
}
