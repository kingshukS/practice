package com.kingshuk.tests;

public class TestIndexOfFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,1,10,10,10,20,20,40};
        int searchKey = 41;
        int index = findFirstOccurrence(arr, arr.length,searchKey);
        System.out.println("First index of :"+searchKey+" is at:"+index);
    }

    public static int findFirstOccurrence(int[] arr, int n, int searchKey) {
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == searchKey){
               if(mid==0 || arr[mid-1] != searchKey){
                   return mid;
               }else{
                   high = mid-1;
               }
            }else if(searchKey<arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
