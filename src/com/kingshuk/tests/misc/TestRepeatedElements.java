package com.kingshuk.tests.misc;

public class TestRepeatedElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2};
        twoRepeated(arr,arr.length);
    }
    public static void twoRepeated(int[] arr, int N)
    {
        // Your code here
        for(int i=0; i<N; i++){
            int index = arr[i] - 1;
            while(index>=0 && index<=N-1 && arr[index]!=arr[i]){
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
                index = arr[i] - 1;
            }
        }

        System.out.println( arr[N-2]);
        System.out.println( arr[N-1]);
    }
}
