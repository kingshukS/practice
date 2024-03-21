package com.kingshuk.tests.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class TestEvenOddSorting {

    public static void main ( String[] args ) {
        Integer[] arr = new Integer[]{ 5, 20, 10, 3, 12 };
        Arrays.sort ( arr );
        Arrays.stream ( arr ).forEach ( System.out::println );
        Arrays.sort ( arr, new EvenOddComparator () );
        Arrays.stream ( arr ).forEach ( System.out::println );
    }
}

class EvenOddComparator implements Comparator<Integer> {

    @Override
    public int compare ( Integer i1, Integer i2 ) {
        return - ( i1 % 2 - i2 % 2 );
    }
}
