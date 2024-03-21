package com.kingshuk.tests.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main ( String[] args ) {
        int[] arr = { 11, 9, 21, 8, 17, 19, 13, 1, 24, 12 };
        int bucketSize = 5;
        applyBucketSort ( arr, bucketSize );
        System.out.println ( Arrays.toString ( arr ) );
    }

    public static void applyBucketSort ( int[] arr, int bucketSize ) {
        int n = arr.length;
        if ( n > 0 ) {
            int maximum = arr[0];
            int index = 0;
            // List of all the buckets
            List<List<Integer>> sorted = new ArrayList<> ();
            for ( int i = 0; i < bucketSize; i++ ) {
                // Adding individual buckets
                sorted.add ( new ArrayList<> () );
            }
            // Find the maximum number present in the array
            for ( int i = 1; i < n; i++ )
                maximum = Math.max ( maximum, arr[i] );
            // Do maximum = maximum + 1, as the bucket exist from 0 to k-1
            maximum++;

            // Traverse through the array and add the elements to the individual buckets respectively
            for ( int i = 0; i < n; i++ ) {
                // Calculate the bucketIndex in a way such that it always lies in between 0 to k-1, as the total bucket size is given as k
                int bucketIndex = ( bucketSize * arr[i] ) / maximum;
                sorted.get ( bucketIndex ).add ( arr[i] );
            }
            // Sort individual buckets
            for ( int i = 0; i < bucketSize; i++ ) {
                System.out.println ( "Sorting the bucket containing: " + sorted.get ( i ).toString () );
                Collections.sort ( sorted.get ( i ) );
            }
            for ( int i = 0; i < bucketSize; i++ ) {
                for ( int j = 0; j < sorted.get ( i ).size (); j++ ) {
                    arr[index++] = sorted.get ( i ).get ( j );
                }
            }
        }
    }
}
