package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.List;

// time complexity: O(2^n)
public class CountAllSubsetsKSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1};
        int k = 2;
        int result = findCountAllSubsetsWithKSum(arr, 0, 0, k);
        System.out.println(result);
    }

    private static int findCountAllSubsetsWithKSum(int[] arr, int index, int curSum, int k) {
        if (index == arr.length) {
            if (curSum == k) {
                return 1;
            }
            return 0;
        }
        curSum += arr[index];
        int l = findCountAllSubsetsWithKSum(arr, index + 1, curSum, k);
        curSum -= arr[index];
        int r = findCountAllSubsetsWithKSum(arr, index + 1, curSum, k);
        return l + r;
    }
}
