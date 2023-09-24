package com.kingshuk.tests.DynamicProgramming;

public class LongestIncreasingSubsequence {

    private static int LIS = Integer.MIN_VALUE;
    static int longestLength(int arr[], int n) {
        int i, j, max = 0;
        int lis[] = new int[n];

        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    static int longestLengthRecursive(int arr[], int n) {
        if(n == 1)
            return 1;

        int max_ending_here = 1, res = 0;

        for(int i = 1; i<n; i++)
        {
            res = longestLengthRecursive(arr, i);

            if(arr[n-1] > arr[i-1] && 1 + res > max_ending_here)
                max_ending_here = 1 + res;
        }

        LIS = Math.max(LIS, max_ending_here);

        return max_ending_here;
    }

    public static void main(String args[]) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;
        System.out.println("Longest increasing subsequence is : " + longestLength(arr, n));
        longestLengthRecursive(arr, n);
        System.out.println(LIS);
    }
}
