package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    public static void main ( String[] args ) {
        List<List<Integer>> ans = new CombinationSum2 ().combinationSum2 ( new int[]{ 1, 2, 1, 2, 1 }, 4 );
        System.out.println ( ans );
    }

    public List<List<Integer>> combinationSum2 ( int[] candidates, int target ) {
        List<List<Integer>> ans = new ArrayList<> ();
        Arrays.sort ( candidates );
        findCombinationSum2 ( 0, candidates, target, new ArrayList<> (), ans );
        return ans;
    }

    private void findCombinationSum2 ( int index, int[] candidates, int target, ArrayList<Integer> ds, List<List<Integer>> ans ) {
        if ( target == 0 ) {
            ans.add ( new ArrayList<> ( ds ) );
            return;
        }

        for ( int ind = index; ind < candidates.length; ind++ ) {
            if ( candidates[ind] > target ) break;
            if ( ind > index && candidates[ind] == candidates[ind - 1] ) continue;
            ds.add ( candidates[ind] );
            findCombinationSum2 ( ind + 1, candidates, target - candidates[ind], ds, ans );
            ds.remove ( ds.size () - 1 );
        }
    }
}