package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        findCombinationSum(index, candidates, ans, ds, target);
        return ans;
    }

    private void findCombinationSum(int index, int[] candidates, List<List<Integer>> ans, List<Integer> ds, int target) {
        if(index == candidates.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index] <= target)
        {
            ds.add(candidates[index]);
            findCombinationSum(index, candidates, ans, ds, target-candidates[index]);
            ds.remove(ds.size()-1);
        }
        findCombinationSum(index+1, candidates, ans, ds, target);
    }
}