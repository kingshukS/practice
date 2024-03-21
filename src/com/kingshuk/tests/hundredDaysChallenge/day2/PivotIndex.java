package com.kingshuk.tests.hundredDaysChallenge.day2;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * <p>
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class PivotIndex {
    public static void main ( String[] args ) {
        int[] arr = { 2, 1, - 1 };
        int pivotIndex = findPivotIndex ( arr );
        if ( pivotIndex == - 1 )
            System.out.println ( "No pivot index exist" );
        else
            System.out.println ( "Pivot Index: " + pivotIndex );
    }

    private static int findPivotIndex ( int[] arr ) {
        int sum = 0;
        for ( int element : arr ) {
            sum += element;
        }
        int leftSum = 0;
        int rightSum = sum;
        for ( int i = 0; i < arr.length; i++ ) {
            rightSum = rightSum - arr[i];
            if ( leftSum == rightSum )
                return i;
            leftSum = leftSum + arr[i];
        }
        return - 1;
    }
}
