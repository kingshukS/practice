package com.kingshuk.tests.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,7,8,3,0,1,7,2};
        applySelectionSort(arr);
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void applySelectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<n-1; i++)
        {
            int min_ind = i;
            for(int j = i+1; j<n; j++)
            {
                if(arr[j]<arr[min_ind])
                    min_ind = j;
            }
            int temp = arr[min_ind];
            arr[min_ind] = arr[i];
            arr[i] = temp;
        }
    }
}
