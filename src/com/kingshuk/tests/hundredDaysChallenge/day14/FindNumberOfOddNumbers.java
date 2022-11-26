package com.kingshuk.tests.hundredDaysChallenge.day14;

/**
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 */
public class FindNumberOfOddNumbers {
        public int countOdds(int low, int high) {
            int nums = high - low + 1;
            if(low%2 == 1 && high%2 == 1)
                return nums/2+1;
            return nums/2;
        }
}
