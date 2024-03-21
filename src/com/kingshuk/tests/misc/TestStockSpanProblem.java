package com.kingshuk.tests.misc;

import java.util.Stack;

public class TestStockSpanProblem {
    public static void main ( String[] args ) {
        int[] arr = new int[]{ 100, 80, 60, 70, 60, 75, 85 };
        findStockSpanOutput ( arr, arr.length );
    }

    private static void findStockSpanOutput ( int[] arr, int n ) {
        Stack<Integer> s = new Stack<> ();
        int[] arr1 = new int[n];
        for ( int i = 0; i < n; i++ ) {
            int sum = 0;
            int num = arr[i];
            while (! s.isEmpty () && num >= arr[s.peek ()]) {
                sum += arr1[s.peek ()];
                s.pop ();
            }
            arr1[i] = 1 + sum;
            s.push ( i );
        }
        for ( int i = 0; i < arr1.length; i++ ) {
            System.out.println ( arr1[i] );
        }
    }
}
