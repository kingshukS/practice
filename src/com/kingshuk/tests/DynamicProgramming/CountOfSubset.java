package com.kingshuk.tests.DynamicProgramming;

public class CountOfSubset {
    /**
     * @param arr   array of numbers
     * @param sum   given sum
     * @param index index starting at n-1 to 0
     * @return
     */

    static int countOfSubsetRecursive ( int[] arr, int sum, int index ) {
        if ( sum == 0 )
            return 1;
        if ( index == 0 )
            return sum == arr[ 0 ] ? 1 : 0;
        /*
        case: XXXX
        -> Considering element == 0, new base case will be as follows:
        if(index == 0)
        {
            if(sum == 0 && arr[0] == 0)
                return 2; // take + not take
            if(sum == 0 || sum == arr[0])// when arr[0] != 0 but sum is 0 (not take case) OR sum is same as arr[0](take case)
                return 1;
            return 0;// all the other cases
        }
      */
        int notTake = countOfSubsetRecursive ( arr, sum, index - 1 );
        int take = 0;
        if ( arr[ index ] <= sum )
            take = countOfSubsetRecursive ( arr, sum - arr[ index ], index - 1 );
        return take + notTake;
    }

    // in terms of size
    static int countSubset ( int[] arr, int sum, int n ) {
        int[][] t = new int[ n + 1 ][ sum + 1 ];
        int i, j;
        for ( i = 0; i < n; i++ )
            t[ i ][ 0 ] = 1;
        t[ 0 ][ 0 ] = 1;
        for ( i = 1; i <= n; i++ ) {
            for ( j = 1; j <= sum; j++ ) {
                if ( arr[ i - 1 ] > j ) {
                    t[ i ][ j ] = t[ i - 1 ][ j ];
                } else {
                    t[ i ][ j ] = t[ i - 1 ][ j ] + t[ i - 1 ][ j - arr[ i - 1 ] ];
                }
            }
        }
        return t[ n ][ sum ];
    }

    // in terms of index
    static int countSubset2 ( int[] arr, int sum, int n ) {
        int[][] t = new int[ n ][ sum + 1 ];
        for ( int i = 0; i < n; i++ )
            t[ i ][ 0 ] = 1;
        if ( arr[ 0 ] <= sum )
            t[ 0 ][ arr[ 0 ] ] = 1;
        for ( int i = 1; i < n; i++ ) {
            for ( int j = 1; j <= sum; j++ ) {
                int notTake = t[ i - 1 ][ j ];
                int take = 0;
                if ( arr[ i ] <= j )
                    take = t[ i - 1 ][ j - arr[ i ] ];
                t[ i ][ j ] = take + notTake;
            }
        }
        return t[ n - 1 ][ sum ];
    }

    static int countSubset2SpaceOptimized ( int[] arr, int sum, int n ) {
        int[] t = new int[ sum + 1 ];
        t[ 0 ] = 1;
        if ( arr[ 0 ] <= sum )
            t[ arr[ 0 ] ] = 1;
        for ( int i = 1; i < n; i++ ) {
            int[] cur = new int[ sum + 1 ];
            cur[ 0 ] = 1;
            for ( int j = 1; j <= sum; j++ ) {
                int notTake = t[ j ];
                int take = 0;
                if ( arr[ i ] <= sum )
                    take = t[ j - arr[ i ] ];
                cur[ j ] = take + notTake;
            }
            t = cur;
        }
        return t[ sum ];
    }

    // case: XXXX: considering elements 0
    static int subsetCountSpecialCase ( int[] arr, int n, int sum ) {
        int[][] dp = new int[ n ][ sum + 1 ];

        if ( arr[ 0 ] == 0 )
            dp[ 0 ][ 0 ] = 2;
        else dp[ 0 ][ 0 ] = 1;

        if ( arr[ 0 ] != 0 && arr[ 0 ] <= sum )
            dp[ 0 ][ arr[ 0 ] ] = 1;

        for ( int i = 1; i < n; i++ ) {
            for ( int j = 0; j <= sum; j++ ) {
                int notTake = dp[ i - 1 ][ j ];
                int take = 0;
                if ( arr[ i ] <= j )
                    take = dp[ i - 1 ][ j - arr[ i ] ];
                dp[ i ][ j ] = ( take + notTake );
            }
        }
        return dp[ n - 1 ][ sum ];
    }

    // case: XXXX: considering elements 0
    static int subsetCountSpecialCaseSpaceOptimized ( int[] arr, int n, int sum ) {
        int[] dp = new int[ sum + 1 ];

        if ( arr[ 0 ] == 0 )
            dp[ 0 ] = 2;
        else dp[ 0 ] = 1;

        if ( arr[ 0 ] != 0 && arr[ 0 ] <= sum )
            dp[ arr[ 0 ] ] = 1;

        for ( int i = 1; i < n; i++ ) {
            int[] cur = new int[ sum + 1 ];
            for ( int j = 0; j <= sum; j++ ) {
                int notTake = dp[ j ];
                int take = 0;
                if ( arr[ i ] <= j )
                    take = dp[ j - arr[ i ] ];
                cur[ j ] = ( take + notTake );
            }
            dp = cur;
        }
        return dp[ sum ];
    }

    // case: XXXX: considering elements 0
    static int subsetCountSpecialCaseSpaceOptimized2 ( int[] arr, int n, int sum ) {
        int[] dp = new int[ sum + 1 ];

        if ( arr[ 0 ] == 0 )
            dp[ 0 ] = 2;
        else dp[ 0 ] = 1;

        if ( arr[ 0 ] != 0 && arr[ 0 ] <= sum )
            dp[ arr[ 0 ] ] = 1;

        for ( int i = 1; i < n; i++ ) {
            for ( int j = sum; j >= 0; j-- ) {
                int notTake = dp[ j ];
                int take = 0;
                if ( arr[ i ] <= j )
                    take = dp[ j - arr[ i ] ];
                dp[ j ] = ( take + notTake );
            }
        }
        return dp[ sum ];
    }

    public static void main ( String[] args ) {
        int[] arr = { 1, 2, 3, 3 };
        int sum = 3;
        int n = arr.length;
        int ans = countSubset ( arr, sum, n );
        System.out.println ( "Count of subset is: " + ans );

        arr = new int[]{ 0, 0, 1 };
        System.out.println ( "Count of subset is (Special Case): " + subsetCountSpecialCaseSpaceOptimized2 ( arr, 3, 1 ) );
    }
}
