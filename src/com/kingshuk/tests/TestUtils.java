package com.kingshuk.tests;

import java.util.Arrays;

public class TestUtils {
    public static void main(String[] args) {
        int a = 5, b = 10;
        swap(a, b);
        System.out.println("Swapped values: a = " + a + ", b = " + b);
        int[] arr = {1,2,3,4,5};
        reverse(arr, 2, arr.length - 1);
        System.out.println("Reversed values: " + Arrays.toString(arr));
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap method: a = " + a + ", b = " + b);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        System.out.println("Inside swap method: a = " + a + ", b = " + b);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
