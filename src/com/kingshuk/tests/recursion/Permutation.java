package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Permutation {

    public static void main(String[] args) {
        List<List<Integer>> res = new Permutation().permute2(new int[]{1,2,3});
        System.out.println(res);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        findPermutations(nums, new ArrayList<Integer>(), vis, ans);
        return ans;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations2(0, nums, ans);
        return ans;
    }

    private void findPermutations2(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length)
        {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++)
        {
            swap(nums, index, i);
            findPermutations2(index+1, nums, ans);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    private void findPermutations(int[] nums, ArrayList<Integer> ds, boolean[] vis, List<List<Integer>> ans) {
        if(ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                ds.add(nums[i]);
                findPermutations(nums, ds, vis, ans);
                ds.remove(ds.size()-1);
                vis[i] = false;
            }
        }
    }
}