package com.kingshuk.tests.recursion;

import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        reverse(arr, 0, 4);
        reverse(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int i) {
        if(i>=arr.length/2)
            return;
        int t = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = t;
        reverse(arr, i+1);
    }

    private static void reverse(int[] arr, int l, int r) {
        if(l>=r)
            return;
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
        reverse(arr, l+1, r-1);
    }
}
