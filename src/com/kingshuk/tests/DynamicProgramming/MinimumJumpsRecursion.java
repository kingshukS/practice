package com.kingshuk.tests.DynamicProgramming;

public class MinimumJumpsRecursion {

    static int minJumpsRequired(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        if (arr[start] == 0)
            return Integer.MAX_VALUE;
        int minJumps = Integer.MAX_VALUE;
        for (int i = start + 1; i <= end && i <= start + arr[start]; i++) {
            int min = minJumpsRequired(arr, i, end);
            if (min != Integer.MAX_VALUE && 1 + min < minJumps)
                minJumps = 1 + min;
        }
        return minJumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int n = arr.length;
        System.out.println("Minimum jumps required " + minJumpsRequired(arr, 0, n - 1));

    }
}
