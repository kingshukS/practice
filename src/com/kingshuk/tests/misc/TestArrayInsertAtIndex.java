package com.kingshuk.tests.misc;

public class TestArrayInsertAtIndex {
    public static void main ( String[] args ) {
        String s = "new string";
        int[] arr = new int[6];
        for ( int i = 0; i < 5; i++ ) {
            arr[i] = i + 1;
        }
        insertAtIndex ( arr, 6, 5, 90 );
        for ( int i : arr ) {
            System.out.println ( i );
        }
    }

    public static void insertAtIndex ( int[] arr, int sizeOfArray, int index, int element ) {
        for ( int i = sizeOfArray - 2; i >= index; i-- ) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
    }
}