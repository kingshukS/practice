package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroesToRight(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
        moveZeroesToLeft(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }

    private static void moveZeroesToRight(int[] arr) {
        int sizeZeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                sizeZeroes++;
            else{
                int t = arr[i];
                arr[i] = 0;
                arr[i-sizeZeroes] = t;
            }
        }
    }

    private static void moveZeroesToLeft(int[] arr) {
        if(arr.length <=1)
            return;
        int readIndex = arr.length - 1;
        int writeIndex = arr.length - 1;
        while(readIndex >= 0){
            if(arr[readIndex] != 0)
            {
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex--;
        }
        while(writeIndex >= 0){
            arr[writeIndex] = 0;
            writeIndex--;
        }
    }
}
