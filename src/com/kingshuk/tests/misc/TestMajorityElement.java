package com.kingshuk.tests.misc;

// Moore’s Voting Algorithm
public class TestMajorityElement {
    public static void main ( String[] args ) {
        int[] a = new int[]{ 1, 3, 3, 1, 2 };

        // Function call
        int size = a.length;
        printMajority ( a, size );
    }

    private static void printMajority ( int[] a, int size ) {
        int count = 1;
        int candidate = a[0];
        for ( int i = 1; i < size; i++ ) {
            if ( a[i] == candidate )
                count++;
            else
                count--;
            if ( count == 0 ) {
                count = 1;
                candidate = a[i];
            }
        }
        count = 0;
        for ( int i = 0; i < size; i++ ) {
            if ( a[i] == candidate )
                count++;
        }
        if ( count > size / 2 )
            System.out.println ( "Majority element = " + candidate );
        else
            System.out.println ( "No majority element exist" );
    }
}
