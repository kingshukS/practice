package com.kingshuk.tests.JustPractice;

import java.util.Stack;

public class NextGreaterElement {

    static void nextGreater(int[] arr)
    {
        int[] arr1 = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=arr[i])
            {
                    s.pop();
            }
            if(s.isEmpty())
            {
                arr1[i] = -1;
            }
            else{
                arr1[i] = s.peek();}
            s.push(arr[i]);
        }

        for(int i=0;i <arr.length;i++)
        System.out.print(arr1[i]+" ");
    }
    public static void main(String[] args)
    {
        int[] arr = { 11, 13, 21, 3 };
        nextGreater(arr);
    }
}
