package com.kingshuk.tests.Arrays;

public class Binarysearch {
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 4;
        Binarysearch binarysearch = new Binarysearch();
        int result = binarysearch.binarySearch(arr,0,n-1,x);
        System.out.println("The element is at "+result+" index");
    }

    public int binarySearch(int[] arr, int l, int r, int x)
    {
       if(r>=l)
       {
           int mid = l + (r-l)/2;

           if(x==arr[mid])
           {
               return mid;
           }

           if(x < arr[mid])
           {
               return binarySearch(arr,l,mid-1,x);
           }
           else
           {
                return binarySearch(arr,mid+1,r,x);
           }
       }
        return -1;
    }
}
