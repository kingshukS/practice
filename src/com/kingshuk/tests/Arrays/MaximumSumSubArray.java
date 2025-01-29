package com.kingshuk.tests.Arrays;

public class MaximumSumSubArray {

    public static void main ( String[] args ) {
        int[] arr = new int[]{ - 2, - 3, 4, - 1, - 2, 1, 5, - 3 };
        maxSubArray ( arr );
    }

    static void maxSubArray (int[] arr) {
        int n = arr.length;
        int sum_till_now = 0;
        int maxSumSofar = 0;
        int start = 0, s = 0, end = 0;
        boolean allNegative = true;
        int maxNegative = Integer.MIN_VALUE; // Track max negative value

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                allNegative = false; // If we find a non-negative number, break this assumption
            }
            maxNegative = Math.max(maxNegative, arr[i]); // Track maximum negative value

            sum_till_now += arr[i];
            if (maxSumSofar < sum_till_now) {
                maxSumSofar = sum_till_now;
                start = s;
                end = i;
            }

            if (sum_till_now < 0) {
                sum_till_now = 0;
                s = i + 1;
            }
        }

        if (allNegative) {
            System.out.println("All elements are negative. The max sum is: " + maxNegative);
        } else {
            System.out.println("The max sum is " + maxSumSofar + " from index " + start + " to " + end);
        }
    }

}
