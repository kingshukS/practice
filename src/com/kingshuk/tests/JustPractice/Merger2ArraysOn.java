package com.kingshuk.tests.JustPractice;

public class Merger2ArraysOn {

    static void mergeArrays ( int[] arr1, int n1, int[] arr2, int n2 ) {
        int[] arr3 = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if ( arr1[i] < arr2[j] ) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }

        for ( int l = 0; l < arr3.length; l++ ) {
            System.out.print ( arr3[l] + " " );
        }
    }

    public static void main ( String[] args ) {
        int[] arr1 = { 1, 3, 4, 7 };
        int[] arr2 = { 2, 5, 6, 9 };
        int n1 = arr1.length;
        int n2 = arr2.length;
        mergeArrays ( arr1, n1, arr2, n2 );
    }
}
