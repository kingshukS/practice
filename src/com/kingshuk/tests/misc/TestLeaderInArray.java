package com.kingshuk.tests.misc;

public class TestLeaderInArray {
    public static void main ( String[] args ) {
        int[] arr = { 8, 6, 3, 4, 5 };
        int n = arr.length;
        printLeaderInOrder ( arr, n );
    }

    private static void printLeaderInOrder ( int[] arr, int n ) {
        int leader = arr[n - 1];
        StringBuilder sb = new StringBuilder ();
        sb.append ( leader + " " );
        for ( int i = n - 2; i >= 0; i-- ) {
            if ( arr[i] > leader ) {
                leader = arr[i];
                sb.append ( leader + " " );
            }
        }
        System.out.println ( sb.reverse () );
    }
}
