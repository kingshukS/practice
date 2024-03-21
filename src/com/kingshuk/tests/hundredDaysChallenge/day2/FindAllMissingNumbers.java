package com.kingshuk.tests.hundredDaysChallenge.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 */
class FindAllMissingNumbers {
    public static void main ( String[] args ) {
        List<Integer> list = new FindAllMissingNumbers ().findDisappearedNumbers ( new int[]{ 4, 3, 2, 7, 8, 2, 3, 1 } );
        System.out.println ( list.toString () );
    }

    public List<Integer> findDisappearedNumbers ( int[] nums ) {
        List<Integer> list = new ArrayList<> ();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if ( nums[correct] == nums[i] )
                i++;
            else {
                int t = nums[correct];
                nums[correct] = nums[i];
                nums[i] = t;
            }
        }

        for ( i = 0; i < n; i++ ) {
            if ( nums[i] != i + 1 )
                list.add ( i + 1 );
        }
        return list;
    }
}