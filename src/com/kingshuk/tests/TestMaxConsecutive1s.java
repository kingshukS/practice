package com.kingshuk.tests;

public class TestMaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int n = arr.length;
        int max_1s = findMaximumConsecutive1s(arr,n);
        System.out.println("Max 1s:"+max_1s);
    }

    private static int findMaximumConsecutive1s(int[] arr, int n) {
       int max = 0;
       int i = 0;
       int counter = 0;
       while(i<n){
           if(arr[i] == 1){
               counter++;
           }else{
               max = Math.max(max,counter);
               counter = 0;
           }
           i++;
       }
       if(arr[n-1] == 1){
           max = Math.max(max,counter);
       }
       return max;
    }
}
