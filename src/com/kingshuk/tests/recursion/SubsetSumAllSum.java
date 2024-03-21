package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Collections;

class SubsetSumAllSum {
    public static void main ( String[] args ) {
        ArrayList<Integer> arr = new ArrayList<> ();
        arr.add ( 1 );
        arr.add ( 2 );
        arr.add ( 3 );

        ArrayList<Integer> ans = new SubsetSumAllSum ().subsetSums ( arr, 3 );
        System.out.println ( ans );
    }

    ArrayList<Integer> subsetSums ( ArrayList<Integer> arr, int N ) {
        ArrayList<Integer> ans = new ArrayList<> ();
        findAllSubsetSum ( 0, 0, arr, N, ans );
        Collections.sort ( ans );
        return ans;
    }

    private void findAllSubsetSum ( int index, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> ans ) {
        if ( index == n ) {
            ans.add ( sum );
            return;
        }
        findAllSubsetSum ( index + 1, sum + arr.get ( index ), arr, n, ans );
        findAllSubsetSum ( index + 1, sum, arr, n, ans );
    }
}