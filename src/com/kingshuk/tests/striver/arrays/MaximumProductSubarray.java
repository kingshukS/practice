package com.kingshuk.tests.striver.arrays;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swapping min and max
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public int maxProductPrefixAndSuffix(int[] nums) {

        int n = nums.length;
        int l = 1, r = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of l or r become 0 then update it to 1
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[n - 1 - i];    //suffix product

            ans = Math.max(ans, Math.max(l, r));
        }

        return ans;
    }
}
