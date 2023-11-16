package com.kingshuk.tests.misc;

public class TestCheckRotatedAndSorted {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        System.out.println(checkRotatedAndSorted(arr, arr.length));
    }

    public static boolean checkRotatedAndSorted(int[] arr, int num){

        // Your code here
        int min = arr[0];
        int min_pos = 0;
        int max = arr[0];
        int max_pos = 0;
        for (int i = 1; i < num; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_pos = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                min_pos = i;
            }
        }

        if (max == num - 1 && min == 0 || max == 0 && min == num - 1)
            return false;// not rotated
        if (Math.abs(min_pos - max_pos) != 1)
            return false;// Not sorted
        if (max_pos < min_pos) {// check for ascending sorting

            int i = min_pos;
            while (i != max_pos) {
                int current = arr[i];
                int next = (i + 1 == num) ? arr[0] : arr[i + 1];

                if (current > next)
                    return false;
                i = (i == num - 1) ? 0 : i + 1;
            }
        }
        if (max_pos > min_pos) {// check for descending order
            int i = max_pos;
            while (i != min_pos) {
                int current = arr[i];
                int next = (i + 1 == num) ? arr[0] : arr[i + 1];
                if (current < next)
                    return false;
                i = (i == num - 1) ? 0 : i + 1;
            }
        }

        return true;

    }
}
