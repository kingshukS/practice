package com.kingshuk.tests.sorting;

public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {10,80,30,90,40,50,70};
        int p = 6;
        int l = 0;
        int h = 6;
        int index = applyLomutoPartition(arr, l, h, p);
        System.out.println("Partition Index:" + index);
    }

    public static int applyLomutoPartition(int[] arr, int l, int h, int p) {
        if (p > h || p < l)
            return -1;
        // Falling back to Standard Lomuto
        swap(arr, p, h);
        int i = l-1;
        int pivot = arr[h];
        for(int j = l; j<=h-1; j++)
        {
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);

        return i+1;
    }
    private static void swap(int[] arr, int i1, int i2)
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
