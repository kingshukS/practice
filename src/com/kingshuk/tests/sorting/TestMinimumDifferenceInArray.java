package com.kingshuk.tests.sorting;

import static com.kingshuk.tests.sorting.QuickSort.quickSort;

public class TestMinimumDifferenceInArray {
    public static void main(String[] args) {
        int[] arr = {1, 8, 12, 5, 18};
        System.out.println("Minimum Difference:" + findMinimumDifference(arr));
    }

    private static int findMinimumDifference(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            res = (arr[i] - arr[i - 1]) > res ? res : (arr[i] - arr[i - 1]);
        }
        return res;
    }
}
