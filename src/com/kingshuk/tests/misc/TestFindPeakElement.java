package com.kingshuk.tests.misc;

public class TestFindPeakElement {
    // A binary search based function
    // that returns index of a peak element
    static int findPeak ( int[] arr, int n ) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            // Find index of middle element
            // (low + high)/2
            int mid = low + ( high - low ) / 2;

            // Compare middle element with its
            // neighbours (if neighbours exist)
            if ( ( mid == 0 || arr[mid - 1] <= arr[mid] )
                    && ( mid == n - 1 || arr[mid + 1] <= arr[mid] ) )
                return mid;

                // If middle element is not peak
                // and its left neighbor is
                // greater than it, then left half
                // must have a peak element
            else if ( mid > 0 && arr[mid - 1] > arr[mid] )
                high = mid - 1;

                // If middle element is not peak
                // and its right neighbor
                // is greater than it, then right
                // half must have a peak
                // element
            else
                low = mid + 1;
        }
        return - 1;
    }

    // Driver method
    public static void main ( String[] args ) {
        int[] arr = { 5, 9, 7, 8, 10, 20, 30, 40, 50 };
        int n = arr.length;
        System.out.println (
                "Index of a peak point is " + findPeak ( arr, n ) );
    }
}
