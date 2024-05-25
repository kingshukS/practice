package com.kingshuk.tests.striver.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    /**
     * Applied for positive and negative and 0
     *
     * @param nums
     * @param k
     * @return
     */
    public static int getLongestSubarray(int[] nums, int k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        preSumMap.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSumMap.get(sum - k) != null) {
                int prev = preSumMap.get(sum - k);
                maxLength = Math.max(maxLength, i - prev);
            }
            if (preSumMap.get(sum) == null) {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    /**
     * Only applied for positive and 0 as arr[i]
     *
     * @param arr
     * @param k
     * @return
     */
    public static int longestSubArrayWithSumK(int[] arr, long k) {
        // Two pointer approach, only for monotonically increasing prefix i.e. (arr[i]>=0)
        int left = 0, right = 0;
        long sum = 0;
        int n = arr.length;
        int maxLength = 0;

        while (right < n) {
            sum += arr[right];

            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 1, -1, -1, 0};
        System.out.println(getLongestSubarray(arr, 0));
    }
}