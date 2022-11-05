package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;

public class MergeSortedArraysInFirstArray {
    public static void main(String[] args) {
        int[] arr1 = {3,4,9,10,0,0,0};
        int m = 4;
        int[] arr2 = {1,7,8};
        int n = 3;
        mergeArrays(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = m+n-1;
        int k = n-1;
        while(i>=0 && k>=0) {
            if(nums1[i]>nums2[k]) {
                nums1[j--] = nums1[i--];
            } else {
                nums1[j--] = nums2[k--];
            }
        }
            while(k>=0) {
                nums1[j--] = nums2[k--];
            }
    }
}
