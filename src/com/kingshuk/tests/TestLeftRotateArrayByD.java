package com.kingshuk.tests;

public class TestLeftRotateArrayByD {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int d = 2;
        int n = arr.length;
        doRotateLeft(arr,n,d);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void doRotateLeft(int[] arr, int n, int d) {
        int[] arr2 = new int[d];
        for(int i = 0; i<d; i++){
            arr2[i] = arr[i];
        }

        for(int i = d; i<n;i++){
            arr[i-d] = arr[i];
        }

        for(int j=0;j<d;j++){
            arr[n-d+j] = arr2[j];
        }
    }
}
