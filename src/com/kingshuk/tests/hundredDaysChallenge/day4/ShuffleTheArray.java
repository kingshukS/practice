package com.kingshuk.tests.hundredDaysChallenge.day4;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4, 7};
        shuffleArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void shuffleArray(int[] arr) {
        int n = arr.length/2;
        for(int i = n; i<arr.length; i++){
            arr[i] = arr[i] * 1024 + arr[i-n];
        }
        int index = 0;
        for(int i = n; i<arr.length; i++, index+=2){
            arr[index] = arr[i]%1024;
            arr[index+1] = arr[i]/1024;
        }
    }

}

