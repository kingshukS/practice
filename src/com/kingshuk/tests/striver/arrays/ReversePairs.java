package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 * <p>
 * A reverse pair is a pair (i, j) where:
 * <p>
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 */
class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};
        System.out.println(new ReversePairs().reversePairs(arr));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;

        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += findReversePairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int i = 0, j = 0, k = low;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    /**
     * Finds the number of reverse pairs in the given array.
     * A reverse pair is a pair (i, j) where:
     * 0 <= i < j < nums.length and
     * nums[i] > 2 * nums[j].
     *
     * @param arr  the input array
     * @param low  the starting index of the subarray
     * @param mid  the middle index of the subarray
     * @param high the ending index of the subarray
     * @return the count of reverse pairs in the subarray
     */
    private int findReversePairs(int[] arr, int low, int mid, int high) {
        // first way - take less than second way , complexity is same
        int count = 0, right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2 * (long) arr[right])) {
                right++;
            }
            count += right - (mid + 1);
        }
        // second way - take a little more time, complexity is same
    /*
    int count = 0, right = mid + 1, left = low;
    while (left <= mid && right <= high) {
        if (arr[left] > 2 * (long) arr[right]) {
            count += mid + 1 - left;
            right++;
        } else {
            left++;
        }
    }
    */
        return count;
    }
}