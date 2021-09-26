package com.kingshuk.tests.sorting;

public class NaivePartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7};
        int p = 5;
        int l = 0;
        int h = 5;
        int index = applyNaivePartition(arr, l, h, p);
        System.out.println("Partition Index:" + index);
    }

    public static int applyNaivePartition(int[] arr, int l, int h, int p) {
        int index = -1;
        int[] temp = new int[h - l + 1];
        int i = -1, k = 0;
        int pivot = arr[p];

        if (p > h || p < l)
            return index;

        // For elements < pivot element
        for (i = l; i <= h; i++) {
            if (arr[i] < pivot)
                temp[k++] = arr[i];
        }

        // For elements == pivot element
        for (i = l; i <= h; i++) {
            if (arr[i] == pivot)
                temp[k++] = arr[i];
        }
        index = k - 1;

        // For elements > pivot element
        for (i = l; i <= h; i++) {
            if (arr[i] > pivot)
                temp[k++] = arr[i];
        }

        // Copying elements
        k = 0;
        for (i = l; i <= h; i++) {
            arr[i] = temp[k++];
        }
        return index;
    }
}
