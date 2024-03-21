package com.kingshuk.tests.hundredDaysChallenge.day17;

import java.util.HashSet;
import java.util.Set;

class ContainsNearbyDuplicate {

    public static void main ( String[] args ) {
        System.out.println ( new ContainsNearbyDuplicate ().containsNearbyDuplicate ( new int[]{ 4, 1, 2, 3, 1, 5 }, 3 ) );
    }

    public boolean containsNearbyDuplicate ( int[] nums, int k ) {
        Set<Integer> hashSet = new HashSet<> ();
        int i = 0;
        int j = 0;
        for ( ; i <= k && i < nums.length; i++ ) {
            if ( hashSet.contains ( nums[i] ) )
                return true;
            hashSet.add ( nums[i] );
        }
        for ( ; i < nums.length; i++ ) {
            hashSet.remove ( nums[j] );
            j++;
            if ( hashSet.contains ( nums[i] ) )
                return true;
            hashSet.add ( nums[i] );
        }
        return false;
    }

    public boolean containsNearbyDuplicate2 ( int[] nums, int k ) {
        Set<Integer> set = new HashSet<Integer> ();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i > k ) set.remove ( nums[i - k - 1] );
            if ( ! set.add ( nums[i] ) ) return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicate3 ( int[] nums, int k ) {
        if ( nums.length < 300 ) {
            for ( int i = 0; i < nums.length; i++ ) {
                int temp = i + k;
                while (i < temp) {
                    if ( temp < nums.length && nums[i] == nums[temp] ) {
                        return true;
                    }
                    temp--;
                }
            }
        } else {
            for ( int i = 0; i < nums.length; i++ ) {
                int temp = i + k;
                if ( temp < nums.length && nums[i] == nums[temp] ) {
                    return true;
                }
            }
        }
        return false;
    }
}