package com.kingshuk.tests.sorting;

import java.util.ArrayList;
import java.util.List;

class FirstMissingPositive {
    public static void main ( String[] args ) {
        System.out.println ( new FirstMissingPositive ().firstMissingPositive ( new int[]{ 4, 3, 2, 7, 8, 2, 3, 1 } ) );
    }

    public int firstMissingPositive ( int[] nums ) {
        int n = nums.length;
        int i = 0;
        List<Integer> list = new ArrayList<> ();
        while (i < n) {
            int element = nums[i];
            int index = element - 1;
            while (index >= 0 && index <= n - 1 && nums[index] != nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index = nums[i] - 1;
            }
            i++;
        }
        for ( i = 0; i < n; i++ ) {
            if ( nums[i] != i + 1 )
                list.add ( i + 1 );
        }
        System.out.println ( list );
        for ( int j = 0; j < n; j++ ) {
            if ( nums[j] != j + 1 )
                return j + 1;
        }
        return n + 1;
    }
}