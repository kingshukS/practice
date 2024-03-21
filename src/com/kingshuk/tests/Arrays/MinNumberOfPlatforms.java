package com.kingshuk.tests.Arrays;

import java.util.Arrays;

public class MinNumberOfPlatforms {

    static int minimumPlats ( int[] arr, int[] dep, int n ) {
        int minPlats = 1;
        int result = 1;
        Arrays.sort ( arr );
        Arrays.sort ( dep );

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if ( arr[i] <= dep[j] ) {
                minPlats++;
                i++;
            } else if ( arr[i] > dep[j] ) {
                minPlats--;
                j++;
            }
            if ( minPlats > result ) {
                result = minPlats;
            }
        }

        return result;
    }

    public static void main ( String[] args ) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        int minPlats = minimumPlats ( arr, dep, n );
        System.out.println ( minPlats );
    }
}
