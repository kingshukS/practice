package com.kingshuk.tests.DynamicProgramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4};
        int n = arr.length;
        System.out.println("Minimum number of multiplications is "
                + matrixChainOrder(arr, n));
    }

    private static int matrixChainOrder(int[] arr, int n) {
        int[][] t = new int[n][n];
        for (int i = 1; i < n; i++)
            t[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i <= n - L; i++) {
                int j = i + L - 1;
                if (j >= n)
                    continue;
                t[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    t[i][j] = Math.min(temp, t[i][j]);
                }
            }
        }
        return t[1][n - 1];
    }
}
