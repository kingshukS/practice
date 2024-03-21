package com.kingshuk.tests.misc;

public class TestMaximumLengthSubarrayEvenOdd {
    public static void main ( String[] args ) {
        int[] arr = { 5, 10, 20, 6, 3, 8 };
        int n = arr.length;
        int max = findMaximumLengthSubarrayEvenOdd ( arr, n );
        int max2 = findMaximumLengthSubarrayEvenOdd ( arr );
        System.out.println ( "Maximum Length is:" + max );
        System.out.println ( "Maximum Length is:" + max2 );
    }

    private static int findMaximumLengthSubarrayEvenOdd ( int[] arr, int n ) {
        int counter = 1;
        int i = 1;
        int max_length = 1;
        boolean isEven = ( arr[0] % 2 == 0 );

        while (i < n) {
            if ( arr[i] % 2 == 0 ) {
                if ( isEven ) {
                    max_length = Math.max ( counter, max_length );
                    counter = 1;
                } else {
                    counter++;
                    max_length = Math.max ( counter, max_length );
                    isEven = true;
                }
            } else {
                if ( isEven ) {
                    counter++;
                    max_length = Math.max ( counter, max_length );
                    isEven = false;
                } else {
                    max_length = Math.max ( counter, max_length );
                    counter = 1;
                }
            }
            i++;
        }
        return max_length;
    }

    private static int findMaximumLengthSubarrayEvenOdd ( int[] arr ) {
        int n = arr.length;
        int i = 1;
        int max_length = 1;
        int counter = 1;
        boolean isEven = ( arr[0] % 2 == 0 );

        while (i < n) {
            if ( ( isEven && arr[i] % 2 == 1 ) || ( ! isEven && arr[i] % 2 == 0 ) ) {
                counter++;
                max_length = Math.max ( counter, max_length );
                isEven = ( arr[i] % 2 == 0 );
            } else {
                isEven = ( arr[i] % 2 == 0 );
                counter = 1;
            }
            i++;
        }
        return max_length;
    }
}
