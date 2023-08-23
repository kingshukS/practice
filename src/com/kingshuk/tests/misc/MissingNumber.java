package com.kingshuk.tests.misc;

public class MissingNumber {

    static void missingNum(int arr[]) {
        int total = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        int actualSum = ((n + 1) * (n + 2)) / 2;
        int missing = actualSum - total;
        System.out.print("Missing num is :" + missing);
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 6};
        missingNum(arr);
    }
}
