package com.kingshuk.tests;

import java.util.HashMap;
import java.util.Map;

public class TestLargestSubarrayWithEqual0sAnd1s {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0};
        int length = findMaxLengthOfArrayWithEqualNumbers(arr, arr.length);
        System.out.println("Maximum length: " + length);
    }

    private static int findMaxLengthOfArrayWithEqualNumbers(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        int maxLength = 0;
        int ending_index = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] == 0 ? -1 : arr[i];
        }

        int i = 0;
        while (i < n) {
            sum += arr[i];
            if (sum == 0) {
                maxLength = i + 1;
                ending_index = i;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > maxLength) {
                    maxLength = i - map.get(sum);
                    ending_index = i;
                }
            } else {
                map.put(sum, i);
            }
            i++;
        }
        System.out.println("Starting Index: " + (ending_index - maxLength + 1) + " Ending Index: " + ending_index);

        for (int j = 0; j < n; j++) {
            arr[j] = arr[j] == -1 ? 0 : arr[j];
        }
        return maxLength;
    }
}
