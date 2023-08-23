package com.kingshuk.tests.misc;

public class TestMaxDiffInOrder {
    public static void main(String[] args) {
        int[] arr = {30,10,8,2};
        int n = arr.length;
        int res = findMaxDiffInOrder(arr,n);
        System.out.println("Max Diff:"+res);
    }

    private static int findMaxDiffInOrder(int[] arr, int n) {
        int min = 0;
        int j = 1;
        int max = Integer.MIN_VALUE;
        while(j<n){
            if(arr[j]>arr[min]){
                max = Math.max(max,arr[j]-arr[min]);
            }
            if(arr[j]<arr[min]){
                min = j;
            }
            j++;
        }
        return max;
    }
}
