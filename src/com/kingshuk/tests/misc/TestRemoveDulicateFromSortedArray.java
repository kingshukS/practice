package com.kingshuk.tests.misc;

public class TestRemoveDulicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {30,30,30,30,40};
        int n = removeDuplicates(arr);
        for(int i=0; i<n; i++){
            System.out.print( arr[i]+" ");
        }
    }

    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int k = 1;
        for(int i = 1; i<n;i++){
            if(arr[i]!=arr[i-1]){
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
