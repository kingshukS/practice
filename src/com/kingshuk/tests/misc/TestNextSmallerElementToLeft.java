package com.kingshuk.tests.misc;

import java.util.Stack;

public class TestNextSmallerElementToLeft {
    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 3, 2, 4 };
        int[] res = findNextSmallerElementToLeft ( arr, arr.length );
        for ( int i = 0; i < res.length; i++ ) {
            System.out.println ( "Element:" + arr[i] + " -> NSEL:" + res[i] );
        }
    }

    private static int[] findNextSmallerElementToLeft ( int[] arr, int n ) {
        int[] res = new int[n];
        Stack<Integer> s = new Stack<> ();
        for ( int i = 0; i < n; i++ ) {
            int num = arr[i];
            while (! s.isEmpty () && s.peek () >= num) {
                s.pop ();
            }
            if ( s.isEmpty () ) {
                res[i] = - 1;
            } else {
                res[i] = s.peek ();
            }
            s.push ( num );
        }
        return res;
    }
}
