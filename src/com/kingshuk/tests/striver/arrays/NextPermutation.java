package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;

import static com.kingshuk.tests.TestUtils.reverse;
import static com.kingshuk.tests.TestUtils.swap;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1};
        new NextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        int index = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for(int i = n-1; i>=0; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index+1, n-1);
    }
}
