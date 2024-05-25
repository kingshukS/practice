package com.kingshuk.tests.striver.arrays;

class SecondLarge {
    static int print2largest(int arr[], int n) {
        int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] > large) {
                secondLarge = large;
                large = arr[i];
            } else if(arr[i] > secondLarge && arr[i]!= large) {
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 10};
        System.out.println(print2largest(arr, arr.length));
    }
}