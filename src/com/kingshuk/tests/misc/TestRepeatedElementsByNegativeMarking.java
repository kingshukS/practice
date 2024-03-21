package com.kingshuk.tests.misc;

public class TestRepeatedElementsByNegativeMarking {
    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 2, 2, 1 };
        twoRepeatedByNegativeMarking ( arr, arr.length );
    }

    public static void twoRepeatedByNegativeMarking ( int[] arr, int N ) {
        for ( int i = 0; i < N; i++ ) {
            int element = Math.abs ( arr[i] );
            if ( arr[element] < 0 )
                System.out.println ( element );
            else
                arr[element] = - arr[element];
        }
    }
}
