package com.kingshuk.tests;

import java.util.Stack;

public class TestNextSmallerElementToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4};
        findNextSmallerElementToLeft(arr, arr.length);
    }

    private static void findNextSmallerElementToLeft(int[] arr, int n) {
        int[] arr1 = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<n; i++){
            int num = arr[i];
            while(!s.isEmpty() && s.peek()>= num){
                s.pop();
            }
            if(s.isEmpty()){
                arr1[i] = -1;
            }else{
                arr1[i] = s.peek();
            }
            s.push(num);
        }

        for(int i = 0; i<n; i++){
            System.out.println("Element:"+arr[i]+" -> NSEL:"+arr1[i]);
        }
    }
}
