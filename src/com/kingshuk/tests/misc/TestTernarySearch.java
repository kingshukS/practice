package com.kingshuk.tests.misc;

public class TestTernarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searhKey = 2;
        int index = findElementByTernarySearch(arr, arr.length, searhKey);
        int index2 = findElementByTernarySearch(arr, 0,arr.length-1, searhKey);
        System.out.println("Found " + searhKey + " at index: " + index+" and at index:"+index2);
    }

    private static int findElementByTernarySearch(int[] arr, int n, int searhKey) {
        int lo = 0;
        int hi = n - 1;
        while (hi >= lo) {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = hi - (hi - lo) / 3;
            if (arr[mid1] == searhKey)
                return mid1;
            if (arr[mid2] == searhKey)
                return mid2;
            if (searhKey < arr[mid1])
                hi = mid1 - 1;
            else if (searhKey > arr[mid2])
                lo = mid2 + 1;
            else {
                lo = mid1 + 1;
                hi = mid2 - 1;
            }
        }
        return -1;
    }

    private static int findElementByTernarySearch(int[] arr, int lo, int hi, int searhKey) {

        if (hi >= lo) {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = hi - (hi - lo) / 3;
            if (arr[mid1] == searhKey)
                return mid1;
            if (arr[mid2] == searhKey)
                return mid2;
            if (searhKey < arr[mid1])
                return findElementByTernarySearch(arr, lo, mid1 - 1, searhKey);
            else if (searhKey > arr[mid2])
                return findElementByTernarySearch(arr, mid2 + 1, hi, searhKey);
            else
                return findElementByTernarySearch(arr, mid1 + 1, mid2 - 1, searhKey);
        }
        return -1;
    }
}
