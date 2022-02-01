package com.kingshuk.tests.Arrays;

public class Segreagte01s {

    static void segregate(int arr[])
    {
        int start = 0;
        int end = arr.length-1;

        while(start<end)
        {
            while(arr[start] == 0)
            {
                start++;
            }
            while(arr[end]==1)
            {
                end--;
            }

            arr[start] = 0;
            start++;
            arr[end] = 1;
            end--;
        }
        for(int i =0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
    public static void main(String args[])
    {
        int arr[]={0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate(arr);

    }
}
