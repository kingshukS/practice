package com.kingshuk.tests.hundredDaysChallenge.day20;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 * Great solution. Below is a little explanation for those having trouble understanding.
 *
 * The problem requires that every number has to be equal or greater than previous number.
 * If we encounter a failing condition where the number is not greater or equal to previous (smaller than previous) we need to make a correction.
 * Correction can be made in either of two ways:
 *
 * Make the previous number smaller or equal to current number
 * Make the current number equal to previous number
 *
 * We can do (1) as long as the number at position i-1 is equal or lower than the i+1 element. (or if i==0).
 *
 * Correction with technique (1) takes priority as there is no risk in lowering the value but there is a risk associated if the value is increased.
 * ( Might not work with the next comparison)
 *
 * We have to make correction with (2) if we cannot achieve it by (1). In which case we increase the value of i+1 element by matching i element.
 *
 * Also, we only compare condition with the previous element only because as we move forward we know the previous numbers are already validated .
 */
public class NonDecreasingSubArray {
    public boolean checkPossibility(int[] nums) {
        boolean lifeUsed = false;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] <= nums[i + 1]) {
                i++;
                continue;
            }
            if (lifeUsed)
                return false;
            if (i == 0 || nums[i + 1] >= nums[i - 1])
                nums[i] = nums[i + 1];
            else
                nums[i + 1] = nums[i];
            lifeUsed = true;
            i++;
        }
        return true;
    }
}
