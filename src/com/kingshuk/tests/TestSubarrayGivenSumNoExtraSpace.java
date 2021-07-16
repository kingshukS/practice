package com.kingshuk.tests;

public class TestSubarrayGivenSumNoExtraSpace {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int n = arr.length;
        int sum = -22;
        subArraySum(arr, n, sum);
    }

    private static void subArraySum(int[] arr, int n, int sum) {
        int minEle = Integer.MAX_VALUE;

        // Find minimum element in the array
        for (int i = 0; i < n; i++)
            minEle = Math.min(arr[i], minEle);

        // Initialize curr_sum as value of
        // first element and starting point as 0
        int curr_sum = arr[0] + Math.abs(minEle);
        int start = 0, i;

        // Starting window length will be 1,
        // For generating new target sum,
        // add abs(minEle) to sum only 1 time
        int targetSum = sum;

        // Add elements one by one to curr_sum
        // and if the curr_sum exceeds the
        // updated sum, then remove starting element
        for (i = 1; i <= n; i++)
        {

            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum - (i - start) *
                    Math.abs(minEle) > targetSum &&
                    start < i)
            {
                curr_sum = curr_sum - arr[start] -
                        Math.abs(minEle);
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum - (i - start) *
                    Math.abs(minEle) == targetSum)
            {
                System.out.println("Sum found between indexes " +
                        start + " and " + (i - 1));
                return;
            }

            // Add this element to curr_sum
            if (i < n)
            {
                curr_sum = curr_sum + arr[i] +
                        Math.abs(minEle);
            }
        }

        // If we reach here, then no subarray
        System.out.println("No subarray found");
    }
}
