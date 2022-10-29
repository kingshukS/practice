package com.kingshuk.tests;

import java.util.ArrayDeque;
import java.util.Arrays;

public class TestNextGreaterElementToLeft {
    public static void main(String[] args) {
        int[] arr = {5,17,8,10,13};
        int[] array1 = findNextGreaterElementToLeft(arr, arr.length);
        Arrays.stream(array1).forEach(i-> System.out.print(i+" "));
    }

    public static int[] findNextGreaterElementToLeft(int[] arr, int n) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
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

       return arr1;
    }
}
