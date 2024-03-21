package com.kingshuk.tests.misc;

public class StockBuySellOneTime {
    public static void main ( String[] args ) {
        int[] arr = { 80, 2, 6, 3, 100 };
        BuySell ( arr );
    }

    static void BuySell ( int[] arr ) {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];

        for ( int i = 0; i < arr.length; i++ ) {
            if ( arr[i] - minElement > maxDiff ) {
                maxDiff = arr[i] - minElement;
            }
            if ( arr[i] < minElement ) {
                minElement = arr[i];
            }
        }
        System.out.println ( "Max difference is " + maxDiff );
        System.out.println ( "Min ele is " + minElement );


    }
}
