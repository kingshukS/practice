package com.kingshuk.tests.hundredDaysChallenge.day20;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArrayExceptSelf {
    public int[] productExceptSelfWithoutExtraSpace(int[] nums) {
        int n = nums.length;

        int[] output = new int[n];
        output[0] = 1;

        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= R;
            R = R * nums[i];
        }
        return output;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left_products = new int[n];
        int[] right_products = new int[n];
        int[] output = new int[n];

        left_products[0] = 1;
        right_products[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left_products[i] = left_products[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right_products[i] = right_products[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            output[i] = left_products[i] * right_products[i];
        }

        return output;
    }
}