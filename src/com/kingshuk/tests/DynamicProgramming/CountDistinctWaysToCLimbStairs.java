package com.kingshuk.tests.DynamicProgramming;

public class CountDistinctWaysToCLimbStairs {
    public static long countDistinctWayToClimbStair ( int nStairs ) {
        if ( nStairs <= 2 )
            return Long.valueOf ( nStairs );
        long prev2 = 1L;
        long prev = 2L;
        long curI = 0L;
        for ( int i = 3; i <= nStairs; i++ ) {
            curI = prev + prev2;
            prev2 = prev;
            prev = curI;
        }

        return curI;
    }

    public static void main ( String[] args ) {
        System.out.println ( countDistinctWayToClimbStair ( 5 ) );
    }
}