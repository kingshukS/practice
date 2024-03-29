package com.kingshuk.tests.hundredDaysChallenge.day14;

import java.util.Arrays;

class MaxProductOfThreeNumbers {
    public int maximumProduct ( int[] nums ) {
        Arrays.sort ( nums );
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        ans = Math.max ( nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3] );

        return ans;
    }
}