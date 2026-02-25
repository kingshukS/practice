package com.kingshuk.tests.striver.arrays;

import static com.kingshuk.tests.TestUtils.reverse;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
class RotateImage {
    public void rotate(int[][] matrix) {
        // Transpose the matrix
        int n = matrix.length;
        for(int i = 0; i<n-1; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                swap(matrix, i, j);
            }
        }

        // reverse the rows
        for(int i = 0; i<n; i++)
        {
            reverse(matrix[i], 0, n-1);
        }
    }

    public void swap(int[][] matrix, int i, int j)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}