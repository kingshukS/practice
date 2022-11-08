package com.kingshuk.tests.hundredDaysChallenge.day3;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the
 * array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int removeVal = 2;
        int limit = removeElement(arr, removeVal);
        for (int i = 0; i < limit; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int removeElement(int[] arr, int removeVal) {
        int count = 0;
        for (int i = 0; i < arr.length;i++)
        {
            if(arr[i] == removeVal)
                count++;
            else{
                int t = arr[i - count];
                arr[i-count] = arr[i];
                arr[i] = t;
            }
        }
        return arr.length - count;
    }
}
