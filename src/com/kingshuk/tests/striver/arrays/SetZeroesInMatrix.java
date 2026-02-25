package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;

/**
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 */
class SetZeroesInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes_spaceOptimized(matrix);

        // Print 2D matrix
        Arrays.stream(matrix)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(val -> System.out.print(val + " "));
                    System.out.println();
                });

    }
    public static void setZeroes(int[][] matrix) {
        boolean [] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void setZeroes_spaceOptimized(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j = 0; j<n; j++){
            if(matrix[0][j]==0){
                firstRowZero=true;
                break;
            }
        }

        for(int i = 0; i<m; i++){
            if(matrix[i][0]==0){
                firstColZero=true;
                break;
            }
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int j = 0; j<n; j++){
                matrix[0][j]=0;
            }
        }

        if(firstColZero){
            for(int i = 0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }
}