package com.kingshuk.tests;

public class StockBuySell {

    static void maxprofit(int arr[],int n)
    {
        int max_diff = arr[1] - arr[0];
        int min_ele = arr[0];

        for(int i = 0;i<n;i++)
        {
            if(arr[i] - min_ele > max_diff)
            {
                max_diff = arr[i] - min_ele;
            }

            if(arr[i] < min_ele)
            {
                min_ele = arr[i];
            }
        }
        System.out.println("Max profit that can be made is : "+ max_diff);


    }
    public static void main(String args[])
    {
        int arr[] = {80, 2, 6, 3, 100};
        int n = arr.length;
        maxprofit(arr,n);
    }
}
