package com.kingshuk.tests;

public class TestLeaderInArray {
    public static void main(String[] args) {
        int[] arr = {8,6,3,4,5};
        int n = arr.length;
        printLeader(arr,n);
    }

    private static void printLeader(int[] arr, int n) {
        int leader = arr[n-1];
        System.out.print(leader+" ");
        for(int i = n-2; i>=0; i--){
            if(arr[i]>leader){
                leader = arr[i];
                System.out.print(leader+" ");
            }
        }
    }
}
