package com.kingshuk.tests;

import java.util.Stack;

public class TestNextGreaterElementToLeft {
    public static void main(String[] args) {
        int[] arr = {5,17,8,10,13};
        findNextGreaterElementToLeft(arr, arr.length);
    }

    private static void findNextGreaterElementToLeft(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++){
            int num = arr[i];
            while(!s.isEmpty() && s.peek()<=num)
                s.pop();
            if(s.isEmpty())
                arr1[i] = -1;
            else
                arr1[i] = s.peek();
            s.push(num);
        }

        for(int i = 0; i<n; i++){
            System.out.println("Element:"+arr[i]+" -> NGEL:"+arr1[i]);
        }
    }
}
