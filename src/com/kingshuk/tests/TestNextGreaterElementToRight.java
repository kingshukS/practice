package com.kingshuk.tests;

import java.util.Stack;

public class TestNextGreaterElementToRight {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4};
        findNextGreaterElement(arr, arr.length);
    }

    private static void findNextGreaterElement(int[] arr, int length) {
        int[] arr1 = new int[length];
        Stack<Integer> s = new Stack<>();
        for(int i = length-1; i>=0; i--){
            int num = arr[i];
            while(!s.isEmpty() && s.peek()<= num){
                s.pop();
            }
            if(s.isEmpty()){
                arr1[i] = -1;
            }else{
                arr1[i] = s.peek();
            }
            s.push(num);
        }

        for(int i = 0; i<length; i++){
            System.out.println("Element:"+arr[i]+" -> NGE:"+arr1[i]);
        }
    }
}
