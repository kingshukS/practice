package com.kingshuk.tests.DynamicProgramming;

public class Kadane {

    static void maxSum(int[] arr) {
        int maxSoFar = 0;
        int maxSum = 0;
        int start = -1, s = 0, end = -1;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];

            if (maxSum < maxSoFar) {
                maxSum = maxSoFar;
                start = s;
                end = i;
            }

            if (maxSoFar < 0) {
                maxSoFar = 0;
                s = i + 1;
            }
        }
        System.out.print("Max sum is " + maxSum + " starting index : " + start + " end index : " + end);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
        maxSum(arr);
    }
}
