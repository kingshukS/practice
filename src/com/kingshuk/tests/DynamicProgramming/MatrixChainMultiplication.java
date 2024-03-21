package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int count = 0;
    static int[][] t;

    public static void main ( String[] args ) {
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        System.out.println ( "Minimum number of multiplications is "
                + matrixChainOrder ( arr ) );
        System.out.println ( count );
    }

    private static int matrixChainOrder ( int[] arr ) {
        int n = arr.length;
        int i = 1;
        int j = n - 1;
        t = new int[n + 1][n + 1];
        for ( int k = 0; k <= n; k++ )
            Arrays.fill ( t[k], - 1 );
        return mcmRecursiveMemoization ( arr, i, j );
    }

    private static int mcmRecursive ( int[] arr, int i, int j ) {
        count++;
        if ( i >= j )
            return 0;
        int min = Integer.MAX_VALUE;
        for ( int k = i; k < j; k++ ) {
            min = Math.min ( mcmRecursive ( arr, i, k ) + mcmRecursive ( arr, k + 1, j ) + arr[i - 1] * arr[k] * arr[j], min );
        }
        return min;
    }

    private static int mcmRecursiveMemoization ( int[] arr, int i, int j ) {
        count++;
        if ( i >= j )
            return 0;
        if ( t[i][j] != - 1 )
            return t[i][j];
        int min = Integer.MAX_VALUE;
        for ( int k = i; k < j; k++ ) {
            int x = t[i][k] != - 1 ? t[i][k] : mcmRecursiveMemoization ( arr, i, k );
            //int x = mcmRecursiveMemoization(arr, i, k);
            int y = t[k + 1][j] != - 1 ? t[k + 1][j] : mcmRecursiveMemoization ( arr, k + 1, j );
            //int y = mcmRecursiveMemoization(arr, k+1, j);
            min = Math.min ( x + y + arr[i - 1] * arr[k] * arr[j], min );
        }
        return t[i][j] = min;
    }

    private static int matrixChainOrder ( int[] arr, int n ) {
        int[][] t = new int[n][n];
        for ( int i = 1; i < n; i++ )
            t[i][i] = 0;

        for ( int L = 2; L < n; L++ ) {
            for ( int i = 1; i <= n - L; i++ ) {
                int j = i + L - 1;
                if ( j >= n )
                    continue;
                t[i][j] = Integer.MAX_VALUE;
                for ( int k = i; k < j; k++ ) {
                    int temp = t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    t[i][j] = Math.min ( temp, t[i][j] );
                }
            }
        }
        return t[1][n - 1];
    }

    private static int mcm ( int[] arr, int n ) {
        int[][] t = new int[n][n];

        for ( int i = n - 1; i >= 1; i-- ) {
            for ( int j = i + 1; j < n; j++ ) {
                int temp = (int) 1e9;
                for ( int k = i; k < j; k++ ) {
                    temp = Math.min ( temp, t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j] );
                }
                t[i][j] = temp;
            }
        }
        return t[1][n - 1];
    }
}
