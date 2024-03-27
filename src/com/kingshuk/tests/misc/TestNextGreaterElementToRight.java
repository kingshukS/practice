package com.kingshuk.tests.misc;

import java.util.ArrayDeque;
import java.util.Arrays;

public class TestNextGreaterElementToRight {

    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 3, 2, 4 };
        int[] arr1 = findNextGreaterElement ( arr, arr.length );
        Arrays.stream ( arr1 ).forEach ( i -> System.out.print ( i + " " ) );
    }

    public static int[] findNextGreaterElement ( int[] arr, int length ) {
        int[] res = new int[length];
        ArrayDeque<Integer> s = new ArrayDeque<> ();
        for ( int i = length - 1; i >= 0; i-- ) {
            int num = arr[i];
            while (! s.isEmpty () && s.peek () <= num) {
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
