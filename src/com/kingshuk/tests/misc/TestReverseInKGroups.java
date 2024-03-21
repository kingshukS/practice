package com.kingshuk.tests.misc;

import java.util.ArrayList;

public class TestReverseInKGroups {
    public static void main ( String[] args ) {
        ArrayList<Integer> arr = new ArrayList<> ();
        arr.add ( 1 );
        arr.add ( 2 );
        arr.add ( 3 );
        arr.add ( 4 );
        arr.add ( 5 );

        int k = 3;
        int n = arr.size ();

        reverseInGroups ( arr, n, k );
        System.out.println ( arr );

    }

    static void reverseInGroups ( ArrayList<Integer> arr, int n, int k ) {
        for ( int i = 0; i < n; i = i + k ) {
            if ( i + k > n ) {
                reverse ( arr, i, n - 1 );
            } else {
                reverse ( arr, i, i + k - 1 );
            }
        }
    }

    static void reverse ( ArrayList<Integer> arr, int lo, int hi ) {
        while (lo < hi) {
            int t = arr.get ( lo );
            arr.set ( lo, arr.get ( hi ) );
            arr.set ( hi, t );
            lo++;
            hi--;
        }
    }
}
