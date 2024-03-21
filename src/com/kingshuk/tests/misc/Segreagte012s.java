package com.kingshuk.tests.misc;

public class Segreagte012s {

    static void segregate ( int[] arr ) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        int temp = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;

                case 2:
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }

        for ( int i = 0; i < arr.length; i++ ) {
            System.out.print ( arr[i] + " " );
        }
    }

    public static void main ( String[] args ) {
        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        segregate ( arr );
    }
}
