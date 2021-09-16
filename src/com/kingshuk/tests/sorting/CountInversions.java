package com.kingshuk.tests.sorting;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = {8, 4, 2, 1};
        int count = findInversionCount(arr);
        System.out.println("Count of Inversions: " + count);
    }

    /**
     * Count the number of inversions required to make the array sorted
     *
     * @param arr Integer array for which inversion is counted
     * @return number of inversions
     */
    public static int findInversionCount(int[] arr) {
        return countInversionUtil(arr, 0, arr.length - 1);
    }

    private static int countInversionUtil(int[] arr, int l, int r) {
        int res = 0;
        if (r > l) {
            int m = (l + r) / 2;
            res += countInversionUtil(arr, l, m);
            res += countInversionUtil(arr, m + 1, r);
            res += countAndMergeInversions(arr, l, m, r);
        }
        return res;
    }

    private static int countAndMergeInversions(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];
        left = Arrays.copyOfRange(arr, l, mid + 1);
        right = Arrays.copyOfRange(arr, mid + 1, r + 1);
        int i = 0, j = 0, k = l, res = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res += n1 - i;
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return res;
    }
}
