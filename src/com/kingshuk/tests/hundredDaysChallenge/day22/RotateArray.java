package com.kingshuk.tests.hundredDaysChallenge.day22;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        new RotateArray().rotateArray(nums, 3);
        Arrays.stream(nums).forEach(a -> System.out.print(a+" "));
    }
    public void rotateArray(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0 , nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
