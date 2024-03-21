package com.kingshuk.tests.Important;

public class Kadane {

    static void largetSum ( int[] arr ) {
        int start = 0, s = 0, end = 0;
        int sum = 0;
        int maxSumtillNow = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            sum = sum + arr[i];
            if ( maxSumtillNow < sum ) {
                maxSumtillNow = sum;
                start = s;
                end = i;
            }
            if ( sum < 0 ) {
                sum = 0;
                s = i + 1;
            }
        }
        System.out.println ( "The max sum is " + maxSumtillNow );
        System.out.print ( "Starting index :" + start + " end index: " + end );
    }

    public static void main ( String[] args ) {
        int[] arr = { - 2, - 3, 4, - 1, - 2, 1, 5, - 3 };
        largetSum ( arr );
    }

}
