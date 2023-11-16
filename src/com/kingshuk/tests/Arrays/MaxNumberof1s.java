package com.kingshuk.tests.Arrays;

public class MaxNumberof1s {
    static final int N = 4;

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}};
        max1sRowname(arr);
    }
    static void max1sRowname(int[][] arr)
    {
        int i=0,j=arr.length-1;
        int row=0;
        for(i =0;i<arr.length;i++)
        {
            while(j>=0 && arr[i][j]==1 )
            {

                    j--;
                row=i;

            }
        }
        System.out.print("row is "+(row+1));
        System.out.print("count is "+(arr.length-1-j));
    }
}
