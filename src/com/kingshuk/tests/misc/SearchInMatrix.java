package com.kingshuk.tests.misc;

public class SearchInMatrix {

    static void searchMatrix(int[][] arr, int ele)
    {
        int n = 4;
        int i=0,j=n-1;
        while(i<n && j>=0)
            {
                if(ele == arr[i][j]) {
                    System.out.println("element found at " + i + " " + j);
                    return;
                }

                if(ele>arr[i][j])
                {
                    i++;
                }
                else
                    j--;
            }
        }

    public static void main(String[] args)
    {
        int[][] arr ={{10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50}};
        int ele = 29;
        searchMatrix(arr,ele);
    }
}
