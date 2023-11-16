package com.kingshuk.tests.Arrays;

public class MatrixSearch {

    static void SearchEle(int[][] arr, int ele)
    {
        int i =0,j=arr.length-1;
        while(i<arr.length && j>=0)
        {
            if(ele == arr[i][j])
            {
                System.out.print("element found at : ["+i+"] "+"["+j+"]");
                break;
            }
            if(arr[i][j] > ele)
            {
                j--;
            }
            else
                i++;

        }

    }
    public static void main(String[] args)
    {
        int[][] arr ={{10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50}};
        int ele = 29;
        SearchEle(arr,ele);
    }
}
