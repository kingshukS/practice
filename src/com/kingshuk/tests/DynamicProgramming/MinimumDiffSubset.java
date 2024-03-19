package com.kingshuk.tests.DynamicProgramming;

public class MinimumDiffSubset {
    static boolean[][] t;
    private static void subsetSum ( int[] arr, int sum, int n ) {

        //base case initialization
        for ( int i = 0; i <= n; i++ ) {
            for ( int j = 0; j <= sum; j++ ) {
                if ( i == 0 )
                    t[ i ][ j ] = false;
                if ( j == 0 )
                    t[ i ][ j ] = true;
            }
        }
        //Choice Diagram code
        for ( int i = 1; i <= n; i++ ) {
            for ( int j = 1; j <= sum; j++ ) {

                if ( arr[ i - 1 ] > j )
                    t[ i ][ j ] = t[ i - 1 ][ j ];
                else {
                    t[ i ][ j ] = t[ i - 1 ][ j ] || t[ i - 1 ][ j - arr[ i - 1 ] ];
                }
            }
        }
    }

    public static void main ( String[] args ) {
        int[] arr = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.println ( getMinimumSubsetSum ( arr ) );
    }

    private static int getMinimumSubsetSum ( int[] arr ) {
        int range = 0;
        int n = arr.length;

        //Calculating the range in which s1 lies
        for ( int i : arr ) {
            range += i;
        }
        int range1 = range / 2;
        int res = range;
        t = new boolean[ n + 1 ][ range1 + 1 ];
        subsetSum ( arr, range1, n );

        // We have to check for the maximum value of s1 in the range of range/2 e.g. sum/2 to 0.
        // Hence, starting from range/2, and we'll have to consider all the n elements. For any t[n][j] = true,
        // where j is maximum

        for ( int j = range1; j >= 0; j-- ) {
            if ( t[ n ][ j ] ) {
                res = range - 2 * j;
                break;
            }
        }
        return res;
    }

    public static int minSubsetSumDifferenceSpaceOptimized ( int[] arr, int n ) {
        int range = 0;

        //Calculating the range in which s1 lies
        for ( int x : arr ) {
            range += x;
        }
        int range1 = range / 2;
        int res = range;
        boolean[] dp = new boolean[ range1 + 1 ];
        subsetSumSpaceOptimized ( arr, range1, n, dp );

        // We have to check for the maximum value of s1 in the range of range/2 e.g. sum/2 to 0.
        // Hence, starting from range/2 and we'll have to consider all the n elements. For any t[n][j] = true,
        // where j is maximum

        for ( int j = range1; j >= 0; j-- ) {
            if ( dp[ j ] ) {
                res = range - 2 * j;
                break;
            }
        }
        return res;
    }

    private static void subsetSumSpaceOptimized ( int[] arr, int sum, int n, boolean[] dp ) {

        //base case initialization
        dp[ 0 ] = true;

        if ( arr[ 0 ] <= sum )
                dp[ arr[ 0 ] ] = true;

        for ( int i = 1; i < n; i++ ) {
            for ( int j = sum; j >= 0; j-- ) {
                boolean notPick = dp[ j ];
                boolean pick = false;
                if ( arr[ i ] <= j )
                    pick = dp[ j - arr[ i ] ];
                dp[ j ] = pick || notPick;
            }
        }
    }
}
