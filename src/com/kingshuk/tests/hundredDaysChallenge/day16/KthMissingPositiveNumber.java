package com.kingshuk.tests.hundredDaysChallenge.day16;

public class KthMissingPositiveNumber {
    public int findKthPositive ( int[] arr, int k ) {
        for ( int i : arr ) {
            if ( i <= k ) k++;
            else break;
        }
        return k;
    }

    public int findKthPositive2 ( int[] arr, int k ) {
        int s = 0, th = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            int h = arr[i] - s - 1;
            th += h;
            if ( th >= k )
                return s + h - ( th - k );
            s = arr[i];
        }
        return arr[arr.length - 1] + ( k - th );
    }

    public int findKthPositiveBS ( int[] arr, int k ) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ( end - start ) / 2;
            if ( arr[mid] - mid - 1 < k )
                start = mid + 1;
            else end = mid - 1;
        }
        return k + start;
    }
}
