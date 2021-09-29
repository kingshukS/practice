package com.kingshuk.tests.sorting;

import static com.kingshuk.tests.sorting.HybridPartition.hybridPartition;

public class TestKthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {13, 8, 20, 33, 1, -6};
        System.out.println("Kth Smallest Element:" + findKthSmallestElement(arr, 3));
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        int index = findKthSmallestElementUtil(arr, k);
        if (index != -1)
            return arr[index];
        //throw new IllegalArgumentException("No proper element found");
        return 99999999;
    }

    private static int findKthSmallestElementUtil(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int p = hybridPartition(arr, lo, hi);
            if (p == k - 1)
                return p;
            else if (p > k - 1)
                hi = p - 1;
            else
                lo = p + 1;
        }
        return -1;
    }
}
