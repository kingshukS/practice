package com.kingshuk.tests;

public class TestMaxAreaRectangleBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println(findMaxArea(matrix, 4, 4));
    }

    private static int findMaxArea(int[][] matrix, int row, int col) {
        int maxArea = 0;
        int[] arr = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0)
                    arr[j] += matrix[i][j];
                else {
                    arr[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,TestMaximumAreaHistogram.findMaximumAreaHistogram(arr,col));
        }
        return maxArea;
    }
}
