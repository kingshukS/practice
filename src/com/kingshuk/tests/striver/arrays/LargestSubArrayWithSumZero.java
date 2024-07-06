package com.kingshuk.tests.striver.arrays;

import java.util.HashMap;
import java.util.Map;

class LargestSubArrayWithSumZero {
    int maxLen(int arr[], int n) {
        int sum = 0, maxLength = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sumIndexMap.get(sum) != null) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }

        }

        return maxLength;
    }
}