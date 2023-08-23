package com.kingshuk.tests.misc;

public class TestMaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int n = arr.length;
        int max_1s = findMaximumConsecutive1s(arr,n);
        System.out.println("Max 1s:"+max_1s);
    }

    public static int findMaximumConsecutive1s(int[] arr, int n) {
       int max = 0;
       int i = 0;
       int counter = 0;
       while(i<n){
           if(arr[i] == 1){
               counter++;
           }else{
               counter = 0;
           }
           max = Math.max(max,counter);
           i++;
       }
       return max;
    }
}
