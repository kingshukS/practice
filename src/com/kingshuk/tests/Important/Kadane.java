package com.kingshuk.tests.Important;

public class Kadane {

    static void largestSumSubArray(int[] arr) {
        int start = 0, s = 0, end = 0;
        int currentSum = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (maxSoFar < currentSum) {
                maxSoFar = currentSum;
                start = s;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                s = i + 1;
            }
        }
        System.out.println("The max currentSum is " + maxSoFar);
        System.out.print("Starting index :" + start + " end index: " + end);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        largestSumSubArray(arr);
    }

}
