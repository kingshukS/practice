package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 *
 * A reverse pair is a pair (i, j) where:
 *
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 */
class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(new ReversePairs().reversePairs(arr));
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] arr, int low, int high)
    {
        int count = 0;
        if(low>=high) return count;

        int mid = low + (high - low)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count+= findReversePairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high)
    {
        int[] left = Arrays.copyOfRange(arr, low, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
        int i = 0, j = 0, k = low;

        while(i<left.length && j < right.length)
        {
            if(left[i]<=right[j])
            {
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i<left.length)
        {
            arr[k++] = left[i++];
        }

        while(j<right.length)
        {
            arr[k++] = right[j++];
        }
    }

    private int findReversePairs(int[] arr, int low, int mid, int high)
    {
        int count = 0, right = mid+1;
        for(int i = low; i<=mid; i++)
        {
            while(right<= high && arr[i]>(2 * (long)arr[right]))
                right++;
            count+= right - (mid+1);
        }
        return count;
    }
}