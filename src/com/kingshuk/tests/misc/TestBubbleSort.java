package com.kingshuk.tests.misc;

public class TestBubbleSort {

    public static void main(String[] args) {
        int[] a = {3,2,1};
        int n = 3;
        int swap = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j< n-1-i; j++){
                if(a[j] > a[j+1]){
                    swap++;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = a[j];
                }
            }
        }
    }
}
