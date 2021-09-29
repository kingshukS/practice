package com.kingshuk.tests.sorting;

public class SegmentTwoTypesElements {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0};
        sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            while (arr[start] == 0)
                start++;
            while (arr[end] == 1)
                end--;
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}
