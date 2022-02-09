package com.kingshuk.tests.DynamicProgramming;

public class MatrixChainMultiplicationRecursiveDP {
    static int[][] t;

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "
                + matrixChainOrderUtil(arr, n));
    }

    private static int matrixChainOrderUtil(int[] arr, int n) {
        t = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = -1;
            }
        }
        return matrixChainOrder(arr, 1, n - 1);
    }

    private static int matrixChainOrder(int[] arr, int i, int j) {
        if (i >= j)
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = t[i][k] != -1 ? t[i][k] : matrixChainOrder(arr, i, k);
            temp += t[k + 1][j] != -1 ? t[k + 1][j] : matrixChainOrder(arr, k + 1, j);
            temp += arr[i - 1] * arr[k] * arr[j];
            min = Math.min(temp, min);
        }
        return t[i][j] = min;
    }
}
