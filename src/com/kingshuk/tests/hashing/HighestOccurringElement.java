package com.kingshuk.tests.hashing;

import java.util.HashMap;
import java.util.Map;

class HighestOccurringElement {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int mostFrequent = Integer.MIN_VALUE;
        int currentCount;
        for (int num : nums) {
            currentCount = map.getOrDefault(num, 0) + 1;
            if (maxCount < currentCount) {
                maxCount = currentCount;
                mostFrequent = num;
            }else if (maxCount == currentCount && num < mostFrequent) {
                mostFrequent = num;
            }
            map.put(num, currentCount);
        }

        return mostFrequent;
    }
}


