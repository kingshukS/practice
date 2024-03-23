package com.kingshuk.tests.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    private static int[][] dp;

    private static int LIS = Integer.MIN_VALUE;

    // not comprehensive
    static int longestLengthRecursive ( int[] arr, int n ) {
        if ( n == 1 )
            return 1;

        int max_ending_here = 1, res = 0;

        for ( int i = 1; i < n; i++ ) {
            res = longestLengthRecursive ( arr, i );

            if ( arr[n - 1] > arr[i - 1] && 1 + res > max_ending_here )
                max_ending_here = 1 + res;
        }

        LIS = Math.max ( LIS, max_ending_here );

        return max_ending_here;
    }

    private static int printLisWithBacktrack ( int[] arr, int n ) {
        int[] dp = new int[n], backtrack = new int[n];
        int max =1;
        int maxIndex = 0;

        for ( int i = 0; i < n; i++ ) {
            dp[i] = 1;
            backtrack[i] = i;
            for ( int j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j] && dp[j] + 1 > dp[i] ) {
                    dp[i] = dp[j] + 1;
                    backtrack[i] = j;
                }
            }
            if ( dp[i] > max ) {
                max = dp[i];
                maxIndex = i;
            }
        }

        int[] lis = new int[max];
        int index = max - 1;
        while (backtrack[maxIndex] != maxIndex) {
            lis[index--] = arr[maxIndex];
            maxIndex = backtrack[maxIndex];
        }
        lis[index] = arr[maxIndex];
        Arrays.stream ( lis ).forEach ( x -> System.out.print ( x + " " ) );
        System.out.println ();
        return max;
    }

    private static int findLisTopDownDP ( int[] arr, int n ) {
        int[][] t = new int[n + 1][n + 1];
        for ( int ind = n - 1; ind >= 0; ind-- ) {
            for ( int pInd = ind - 1; pInd >= - 1; pInd-- ) {
                int len = t[ind + 1][pInd + 1];
                if ( pInd == - 1 || arr[ind] > arr[pInd] ) {
                    len = Math.max ( 1 + t[ind + 1][ind + 1], len );
                }
                t[ind][pInd + 1] = len;
            }
        }
        return t[0][- 1 + 1];
    }

    private static int findLisTopDownDPSpaceOptimized ( int[] arr, int n ) {
        int[] next = new int[n + 1], cur;
        for ( int ind = n - 1; ind >= 0; ind-- ) {
            cur = new int[n + 1];
            for ( int pInd = ind - 1; pInd >= - 1; pInd-- ) {
                int len = next[pInd + 1];
                if ( pInd == - 1 || arr[ind] > arr[pInd] ) {
                    len = Math.max ( 1 + next[ind + 1], len );
                }
                cur[pInd + 1] = len;
            }
            next = cur;
        }
        return next[0];
    }

    private static int findLisMemoization ( int[] arr, int index, int prev ) {
        if ( index == arr.length )
            return 0;
        // return from here if pre-calculated, prev index starts form -1,
        // so adding +1 to it (during storing and fetching)
        if ( dp[index][prev + 1] != - 1 ) return dp[index][prev + 1];

        int len = findLisMemoization ( arr, index + 1, prev );
        if ( prev == - 1 || arr[index] > arr[prev] ) {
            len = Math.max ( 1 + findLisMemoization ( arr, index + 1, index ), len );
        }
        return dp[index][prev + 1] = len;
    }

    private static int findLisRecursive ( int[] arr, int index, int prev ) {
        if ( index == arr.length )
            return 0;
        int len = findLisRecursive ( arr, index + 1, prev );
        if ( prev == - 1 || arr[index] > arr[prev] ) {
            len = Math.max ( 1 + findLisRecursive ( arr, index + 1, index ), len );
        }
        return len;
    }

    private static int findLisBinarySearchBest ( int[] arr, int n ) {
        List<Integer> list = new ArrayList<> ();
        list.add ( arr[0] );
        for ( int i = 1; i < n; i++ ) {
            if ( arr[i] > list.get ( list.size () - 1 ) ) {
                list.add ( arr[i] );
            } else {
                int index = binarySearch ( list, arr[i] );
                list.remove ( index );
                list.add ( index, arr[i] );
            }
        }
        return list.size ();
    }

    static int binarySearch ( List<Integer> list, int k ) {
        int low = 0;
        int high = list.size () - 1;
        while (low <= high) {
            int mid = low + ( high - low ) / 2;
            if ( list.get ( mid ) == k )
                return mid;
            else if ( k < list.get ( mid ) ) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main ( String[] args ) {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int n = arr.length;
        // index can be from 0 to n-1, size = n
        // prev can be from -1 to n-2 (when index is n-1 prev can be at max n-2), after
        // co-ordinate shift, 0 to n-1, size = n
        dp = new int[n][n];
        for ( int x = 0; x < dp.length; x++ )
            Arrays.fill ( dp[x], - 1 );
        System.out.println ( "LIS::> " + findLisMemoization ( arr, 0, - 1 ) );
        System.out.println ( findLisBinarySearchBest ( arr, n ) );
        System.out.println ( findLisRecursive ( arr, 0, - 1 ) );
        System.out.println ( findLisTopDownDP ( arr, n ) );
        System.out.println ( printLisWithBacktrack ( arr, n ) );
        System.out.println ( findLisTopDownDPSpaceOptimized ( arr, n ) );
    }
}
