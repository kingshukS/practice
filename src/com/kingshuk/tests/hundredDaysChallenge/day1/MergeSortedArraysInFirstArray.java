package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of
 * elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this,
 * nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set
 * to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArraysInFirstArray {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 9, 10, 0, 0, 0};
        int m = 4;
        int[] arr2 = {1, 7, 8};
        int n = 3;
        mergeArrays(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = m + n - 1;
        int k = n - 1;
        while (i >= 0 && k >= 0) {
            if (nums1[i] > nums2[k]) {
                nums1[j--] = nums1[i--];
            } else {
                nums1[j--] = nums2[k--];
            }
        }
        // nums1 is already present and sorted in the resultant nums1 array, so need to take care of only nums2
        while (k >= 0) {
            nums1[j--] = nums2[k--];
        }
    }
}
