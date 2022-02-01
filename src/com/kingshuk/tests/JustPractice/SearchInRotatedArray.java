package com.kingshuk.tests.JustPractice;

public class SearchInRotatedArray {
    static int search(int arr[],int ele,int low,int high)
    {
        if(high<low)
            return -1;
        int mid = (low + high ) /2;
        if(ele == arr[mid])
            return mid;

        if(arr[low]<= arr[mid]) //first part of array is sorted.
        {
            if(ele <= arr[mid] && ele >=arr[low])
                return search(arr,ele,low,mid-1);
            else
                return search(arr,ele,mid+1,high);
        }

        if(ele >= arr[mid] && ele <= arr[high])

            return search(arr,ele,mid+1,high);

            return search(arr,ele,low,mid-1);
    }
    public static void main(String args[])
    {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int ele = 10;
        int low = 0;
        int high = arr.length-1;
        System.out.print(search(arr,ele,low,high));
    }
}
