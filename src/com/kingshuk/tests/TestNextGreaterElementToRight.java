package com.kingshuk.tests;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class TestNextGreaterElementToRight {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4};
        int[] arr1 = findNextGreaterElement(arr, arr.length);
        Arrays.stream(arr1).forEach(i-> System.out.print(i+" "));
    }

    public static int[] findNextGreaterElement(int[] arr, int length) {
        int[] arr1 = new int[length];
        ArrayDeque<Integer> s = new ArrayDeque<>();
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

        return arr1;
    }
}
