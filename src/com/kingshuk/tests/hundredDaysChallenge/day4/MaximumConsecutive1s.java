package com.kingshuk.tests.hundredDaysChallenge.day4;


import static com.kingshuk.tests.misc.TestMaxConsecutive1s.findMaximumConsecutive1s;

public class MaximumConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        int maxConsecutive1s = findMaximumConsecutive1s(arr, arr.length);
        System.out.println("Maximum consecutive 1s: "+maxConsecutive1s);
    }
}
