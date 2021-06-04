package com.kingshuk.tests;

import java.util.Arrays;

public class TestMaximumOccurredInteger {
    public static void main(String[] args) {
        int L[] = {1,4,3,1};
        int R[] = {15,8,5,999};
        System.out.println(maxOccured(L,R,L.length));
    }

    private static int maxOccured(int[] L, int[] R, int n) {
        int[] arr = new int[1001];// assumption: max R value is 999
        Arrays.fill(arr,0);
        int maxR = -1;
        int ind = -1;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            arr[L[i]]++;
            arr[R[i]+1]--;
            maxR = Math.max(maxR,R[i]);
        }
        for(int i=0;i<maxR+2;i++){
            if(i!=0)
                arr[i] += arr[i-1];
            if(arr[i]>maxSum){
                maxSum = arr[i];
                ind = i;
            }
        }
        return ind;
    }
}
