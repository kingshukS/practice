package com.kingshuk.tests.misc;

public class TestFrequencyInSortedArray {
    public static void main ( String[] args ) {
        int[] arr = { 40, 50, 50, 50 };
        int n = arr.length;
        printElementWithFrequency ( arr, n );
    }

    private static void printElementWithFrequency ( int[] arr, int n ) {
        if ( n == 0 ) {
            return;
        }
        int i = 0;
        int counter = 0;
        int elem = arr[0];
        while (i < n) {
            if ( elem == arr[i] ) {
                counter++;
            } else {
                System.out.println ( "Element:" + elem + " frequency:" + counter );
                elem = arr[i];
                counter = 1;
            }
            i++;
        }
        System.out.println ( "Element:" + elem + " frequency:" + counter );
    }
}
