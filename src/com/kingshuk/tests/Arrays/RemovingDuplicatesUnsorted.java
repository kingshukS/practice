package com.kingshuk.tests.Arrays;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemovingDuplicatesUnsorted {

    public static void main ( String[] args ) {
        RemovingDuplicatesUnsorted removingDuplicatesUnsorted = new RemovingDuplicatesUnsorted();
        int[] arr = { 1, 3, 2, 5, 4, 3, 2, 2, 7, 8, 1, 5 };
        int n = arr.length;
        LinkedHashSet<Integer> linkedHashSet;
        linkedHashSet = removingDuplicatesUnsorted.remDups ( arr, n );
        System.out.println ( linkedHashSet );

        //For Java8 only
        Integer[] origArray = new Integer[]{ 1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 8 };
        List<Integer> listWithoutDuplicates = Arrays.asList ( origArray ).stream ().distinct ().collect ( Collectors.toList () );
        System.out.println ( listWithoutDuplicates );
    }

    public LinkedHashSet<Integer> remDups ( int[] arr, int n ) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<> ();
        for ( int i = 0; i < n; i++ ) {
            lhs.add ( arr[i] );
        }
        return lhs;
    }
}
