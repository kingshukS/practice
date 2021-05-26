package com.kingshuk.tests;

public class TestOneOddAppearing {
    public static void main(String[] args) {
        int[] arr = {3,2,4,5,4,4,4,5,2,0,0};
        int xor = 0;
        for(int i=0; i<arr.length;i++)
            xor = xor ^ arr[i];
        System.out.println(xor);
    }
}
