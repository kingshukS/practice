package com.kingshuk.tests.misc;

public class TestSearchInSortedRotatedArray {
    public static void main ( String[] args ) {
        int[] arr = { 10, 20, 30, 40, 50, 8, 9 };
        int x = 20;
        int index = findElementInSortedRotatedArray ( arr, arr.length, x );
        System.out.println ( "Element x=" + x + " is present at index=" + index );
    }

    // Time-complexity=BigO(log n)
    // If we find the mid position, one half of the array has to be sorted
    private static int findElementInSortedRotatedArray ( int[] arr, int n, int x ) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = ( low + high ) / 2;
            if ( arr[mid] == x )
                return mid;
            // first-half is sorted
            if ( arr[low] <= arr[mid] ) {
                // x lies in first-half, as the first-half is sorted
                if ( arr[low] <= x && arr[mid] >= x ) {
                    high = mid - 1;
                } else {
                    // search in second-half
                    low = mid + 1;
                }
            } else {
                // second-half is sorted
                // x lies in second-half, as the second-half is sorted
                if ( arr[mid + 1] <= x && arr[high] >= x ) {
                    low = mid + 1;
                } else {
                    // search in first-half
                    high = mid - 1;
                }
            }
        }
        return - 1;
    }
}
