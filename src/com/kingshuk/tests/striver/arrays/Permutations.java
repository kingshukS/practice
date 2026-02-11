package com.kingshuk.tests.striver.arrays;

public class Permutations {

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Permutation generator — O(n!)
    private static void permute(int[] arr, int left, int right) {
        if (left == right) {
            // Print the permutation
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(arr, left, i);               // Fix element at 'left'
            permute(arr, left + 1, right);    // Permute the remaining positions
            swap(arr, left, i);               // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, 0, arr.length - 1);
    }
}
