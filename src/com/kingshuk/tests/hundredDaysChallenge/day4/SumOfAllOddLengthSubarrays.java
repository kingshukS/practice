package com.kingshuk.tests.hundredDaysChallenge.day4;

import java.util.Arrays;

public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        int sum = findSumOfAllOddLengthSubarraysFormula(arr);
        System.out.printf("Sum is: "+sum);
    }

    private static int findSumOfAllOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int length = 1; length<=n; length=length+2){
            for(int start = 0; start<n; start++){
                int startIndex = start;
                int endIndex = startIndex + length - 1;
                if(endIndex<n)
                    sum+= Arrays.stream(Arrays.copyOfRange(arr, startIndex, endIndex+1)).sum();
                else
                    break;
            }
        }
        return sum;
    }

    private static int findSumOfAllOddLengthSubarraysFormula(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++){
           sum+= ((i+1)*(n-i)+1)/2*arr[i];
        }
        return sum;
    }
}

