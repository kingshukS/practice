package com.kingshuk.tests.Arrays;

public class Segreagte012 {

    static void segregate(int arr[])
    {
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        int temp;
        while(mid<=high)
        {
            switch (arr[mid])
            {
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }

        System.out.println("afetr segregation:");
        for(int i =0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[])
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        segregate(arr);
    }
}
