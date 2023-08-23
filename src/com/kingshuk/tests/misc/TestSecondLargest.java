package com.kingshuk.tests.misc;

public class TestSecondLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{12,8,12,7};
        System.out.println(printSecondLargestIndex(arr,arr.length));
    }

    private static int printSecondLargestIndex(int[] arr, int n) {
        int res = 0;
        int largest = 0;
        for(int i = 1; i<n; i++){
            if(arr[i]>arr[largest]){
                res = largest;
                largest = i;
            }else if(res == largest && arr[i]<arr[res]){
                res = i;
            }else if(arr[i]>arr[res] && arr[i]<arr[largest]){
                res = i;
            }
        }
        if(largest == res)
            return -1;
        return res;
    }
}
