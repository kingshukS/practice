package com.kingshuk.tests;

public class TestUnboundedBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int x = 55;
        for(int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
        System.out.println("Position of X="+findElement(arr,x));
    }

    private static int findElement(int[] arr, int x) {
     int low = 0;
     int high = 0;
     while(arr[high]<x && high<= arr.length-1){
         if(high == 0){
             high = 1;
         }else{
             high = high*2;
         }
     }
     if(arr[high]==x)
         return high;
     if(high ==1)
         return -1;
     low = high/2+1;
     high = high -1;
     while(low<=high){
         int mid = (low+high)/2;
         if(arr[mid] == x)
             return mid;
         else if(arr[mid]>x){
             high = mid-1;
         }else{
             low = mid+1;
         }
     }
     return -1;
    }
}
