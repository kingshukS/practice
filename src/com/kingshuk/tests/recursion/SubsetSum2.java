package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetSum2 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new SubsetSum2().subsetsWithDup(new int[]{1,2,2});
        System.out.println(ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubsetSum2(0, nums.length, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void findSubsetSum2(int index, int n, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        if(index == n)
            return;
        for(int i = index; i < n; i++)
        {
            if(i>index && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsetSum2(i+1,n, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}