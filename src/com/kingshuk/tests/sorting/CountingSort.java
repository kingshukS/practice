package com.kingshuk.tests.sorting;

import java.util.Arrays;

import static com.kingshuk.tests.sorting.HoarePartition.swap;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {0,3,2,2,5,1};
        int k = 6;
        applyCountingSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void applyCountingSort(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[k];
        int[] output = new int[n];
        for(int i = 0; i<n; i++){
            count[arr[i]]++;
        }

        for(int i=1; i<k; i++){
            count[i] = count[i-1] + count[i];
        }

        for(int i = n-1; i>=0; i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n - 1 + 1);
    }
}
