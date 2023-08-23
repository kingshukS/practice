package com.kingshuk.tests.misc;

import java.util.Arrays;

public class TestAndWriteFrequencyCount {
    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 3, 5,0,-10,25,11,-1,6};
        int N = arr.length;
        int P = 25;
        frequencyCount( arr,  N, P);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void frequencyCount(int[] arr, int n, int p) {
        int p_index = 0;
        for(int i = 0; i <n; i++){
            if(arr[i]>0 && arr[i]<=n){
                arr[p_index++] = arr[i];
            }
        }
        int x = n+1;
        for(int i = p_index; i<n; i++){
            arr[i] = 0;
        }
        Arrays.fill(arr,p_index,n,0);
        for(int i = 0; i <p_index; i++){
            int index = arr[i]%x - 1;
            arr[index]+=x;
        }
        for(int i = 0; i <n; i++){
            arr[i] = arr[i]/x;
        }
    }
}
