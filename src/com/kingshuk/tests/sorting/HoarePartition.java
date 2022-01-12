package com.kingshuk.tests.sorting;

public class HoarePartition {
    public static void main(String[] args) {
        int[] arr = {10,80,30,90,40,50,70};
        int p = 6;
        int l = 0;
        int h = 6;
        int index = applyHoarePartition(arr, l, h, p);
        System.out.println("Partition Index:" + index);
    }

    public static int applyHoarePartition(int[] arr, int l, int h, int p) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If two pointers met or cross eac other
            if (i >= j)
                return j;
            swap(arr, i, j);
        }
    }
    public static void swap(int[] arr, int i1, int i2)
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
