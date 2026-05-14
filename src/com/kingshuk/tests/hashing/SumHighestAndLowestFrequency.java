package com.kingshuk.tests.hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SumHighestAndLowestFrequency {
    public static void main(String[] args) {

        int[] numbers = {
                5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000};

        System.out.println(sumHighestAndLowestFrequency(numbers));
    }

    public static int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int highestFrequency = Integer.MIN_VALUE;
        // Populate map
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            highestFrequency = Math.max(highestFrequency, count);
        }

        int lowestFrequency = Collections.min(map.values());

        return highestFrequency + lowestFrequency;
    }
}
