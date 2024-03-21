package com.kingshuk.tests.misc;

import java.util.Stack;

public class TestNextSmallerElementToRight {

    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 3, 2, 4 };
        findNextSmallerElementToRIght ( arr, arr.length );
    }

    private static void findNextSmallerElementToRIght ( int[] arr, int n ) {
        int[] arr1 = new int[n];
        Stack<Integer> s = new Stack<> ();
        for ( int i = n - 1; i >= 0; i-- ) {
            int num = arr[i];
            while (! s.isEmpty () && s.peek () >= num) {
                s.pop ();
            }
            if ( s.isEmpty () ) {
                arr1[i] = - 1;
            } else {
                arr1[i] = s.peek ();
            }
            s.push ( num );
        }

        for ( int i = 0; i < n; i++ ) {
            System.out.println ( "Element:" + arr[i] + " -> NSE:" + arr1[i] );
        }
    }
}
