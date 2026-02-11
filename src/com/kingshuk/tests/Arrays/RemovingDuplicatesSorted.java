package com.kingshuk.tests.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.kingshuk.tests.Test.swap;

public class RemovingDuplicatesSorted {

    // Function to remove duplicates from sorted array
    public static int removeDuplicates(int[] arr, int n ) {
        int j = 0;
        for ( int i = 0; i < n - 1; i++ ) {
            if ( arr[i] != arr[i + 1] ) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];
        return j;
    }

    public static int removeDuplicates2(int[] arr, int n ) {
        if(n <= 1)
            return n;

        int i = 0;
        for (int j = 1; j< n; j++){
            if(arr[i] != arr[j])
            {
                arr[++i] = arr[j];
            }
        }
        return i+1;
    }

    public static int removeDuplicates3(int[] arr, int n){
        if(n <= 1)
            return n;

        int prev = arr[0];
        int d = 0;
        for(int i = 1; i<n; i++)
        {
            if(arr[i] == prev){
                d++;
            }else{
                prev = arr[i];
                swap(arr, i, i - d);
            }
        }
        return n - d;
    }

    public static void main ( String[] args ) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int n = arr.length;
        int j = removeDuplicates( arr, n );
        System.out.println(Arrays.stream(arr)
                .limit(j)
                .boxed()
                .toList());
    }
}
