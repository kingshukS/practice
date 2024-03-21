package com.kingshuk.tests.sorting;

public class BubbleSort {
    public static void main ( String[] args ) {
        int[] arr = { 5, 4, 7, 8, 3, 0, 1, 7, 2 };
        applyBubbleSort ( arr );
        for ( int i = 0; i < arr.length; i++ ) {
            System.out.print ( arr[i] + " " );
        }
    }

    public static void applyBubbleSort ( int[] arr ) {
        boolean swapped = false;
        int n = arr.length;
        if ( n < 2 )
            return;
        // last element will be in correct place automatically, 0 to n-2 i.e. n-1 iterations
        for ( int j = 0; j < n - 1; j++ ) {
            swapped = false;
            for ( int i = 0; i < n - j - 1; i++ ) {
                if ( arr[i] > arr[i + 1] ) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if ( ! swapped )
                break;
        }
    }
}
