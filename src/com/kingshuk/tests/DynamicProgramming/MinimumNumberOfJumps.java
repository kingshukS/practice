package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int size = arr.length;
        System.out.println("\nMinimum number of jumps to reach end is = " + minJumps(arr, size));
    }

    private static int minJumps(int[] arr, int size) {
        int[] minJumps = new int[size];
        int[] track = new int[size];
        String path = "";
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        track[0] = -1;
        int j = 0;
        for (int i = 1; i < size; i++) {
            j = 0;
            while (j < i) {
                if (j + arr[j] >= i && minJumps[j] != Integer.MAX_VALUE) {
                    if (minJumps[j] + 1 < minJumps[i]) {
                        minJumps[i] = minJumps[j] + 1;
                        track[i] = j;
                    }
                    break;
                }
                j++;
            }
        }
        // track the path
        j = size - 1;
        while (j >= 0) {
            path += j;
            j = track[j];
        }
        path = new StringBuilder(path).reverse().toString();
        System.out.print("Path is:");
        for (int i = 0; i < path.length(); i++) {
            System.out.print(path.charAt(i) + (i == path.length() - 1 ? "" : "->"));
        }

        return minJumps[size - 1];
    }
}
