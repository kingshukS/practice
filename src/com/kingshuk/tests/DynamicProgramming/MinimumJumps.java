package com.kingshuk.tests.DynamicProgramming;

public class MinimumJumps {

    static int minJumpsRequired(int arr[]) {
        int n = arr.length;
        int i, j;
        int jumps[] = new int[n];
        int[] track = new int[n];

        if (n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }
        jumps[0] = 0;
        track[0] = -1;

        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    if (jumps[j] + 1 < jumps[i]) {
                        jumps[i] = jumps[j] + 1;
                        track[i] = j;
                    }
                    break;
                }
            }
        }
        String path = "";
        j = n - 1;
        while (j >= 0) {
            path += j;
            j = track[j];
        }
        System.out.println(path);
        return jumps[i - 1];
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println("Minimum jumps required " + minJumpsRequired(arr));

    }
}
