package com.kingshuk.tests.hashing;

import java.util.HashMap;
import java.util.Map;

class SecondHighestOccurringElement {
    public int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int secondMaxCount = 0;
        int secondMostFrequent = Integer.MIN_VALUE;

        // Populate map
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            maxCount = Math.max(maxCount, count);
        }

        // Find second max frequent number
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(count < maxCount && count > secondMaxCount){
                secondMostFrequent = num;
                secondMaxCount = count;
            }else if (count == secondMaxCount && num < secondMostFrequent){
                secondMostFrequent = num;
            }
        }

        return secondMostFrequent == Integer.MIN_VALUE ? -1 : secondMostFrequent;
    }
}


