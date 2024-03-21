package com.kingshuk.tests.JustPractice;

public class MinEleinRotatedArray {

    static int minEle ( int[] arr, int low, int high ) {
        if ( high < low ) {
            return 0;
        }
        if ( high == low ) {
            return low;
        }
        int mid = low + ( high - low ) / 2;
        if ( mid < high && arr[mid + 1] < arr[mid] ) {
            return arr[mid + 1];
        }
        if ( mid > low && arr[mid] < arr[mid - 1] ) {
            return mid;
        }

        if ( arr[high] > arr[mid] ) {
            return minEle ( arr, low, mid - 1 );
        }
        return minEle ( arr, mid + 1, high );

    }

    public static void main ( String[] args ) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 1 };
        int low = 0;
        int high = arr.length - 1;
        System.out.println ( "min element is at position: " + minEle ( arr, low, high ) );
    }
}
