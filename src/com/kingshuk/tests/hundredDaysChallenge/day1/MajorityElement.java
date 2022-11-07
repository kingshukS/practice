package com.kingshuk.tests.hundredDaysChallenge.day1;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        findAndPrintMajorityElement(arr);
    }

    // Moore's Voting Algorithm
    private static void findAndPrintMajorityElement(int[] arr) {
        int n = arr.length;
        int maj_index = 0;
        int count = 1;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[maj_index])
                count++;
            else
                count--;
            if (count == 0) {
                count = 1;
                maj_index = i;
            }
            i++;
        }
        count = 0;
        i = 0;
        while (i < n) {
            if (arr[i] == arr[maj_index])
                count++;
            i++;
        }
        if (count > n / 2)
            System.out.println("Majority element: " + arr[maj_index]);
        else
            System.out.println("No majority element found!!");
    }
}
