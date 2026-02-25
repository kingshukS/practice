package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        int longest = 0;

        for(int i = 0; i<nums.length; i++)
        {
            int x = nums[i];
            count = 1;
            while(search(nums, x+1))
            {
                x++;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public int longestConsecutive2(int[] nums) {

        Arrays.sort(nums);
        int lastElem = nums[0];
        int maxCount = 1;
        int cur = 1;

        for(int i = 1; i<nums.length; i++)
        {
            if(nums[i] == lastElem+1)
            {
                lastElem = nums[i];
                cur++;
            }else if(nums[i] != lastElem)
            {
                lastElem = nums[i];
                cur = 1;
            }
            maxCount = Math.max(maxCount, cur);
        }

        return maxCount;
    }

    public int longestConsecutive3(int[] nums) {

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int result = 0;
        for(int x : nums){
            if(!numSet.contains(x-1)){
                int count = 1;
                while(numSet.contains(x+1))
                {
                    count++;
                    x++;
                }
                result = Math.max(count, result);
            }
        }
        
        return result;
    }

    // Ref: https://leetcode.com/problems/longest-consecutive-sequence/solutions/7555212/actual-on-solution-no-sorting-no-hashset-8oju
    public int longestConsecutive4(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int num : nums){
            int left = 0 ; int right = 0 ;
            if(map.containsKey(num)) continue ;

            if(map.containsKey(num-1)){
                left = map.get(num-1);
            }

            if(map.containsKey(num+1)){
                right = map.get(num+1);
            }

            int sum = 1 + left + right;
            map.put(num , sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
            max = Math.max(max , sum);
        }
        return max ;
    }

    private boolean search(int[] nums, int elem) {
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == elem)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4};
        System.out.println(new LongestConsecutive().longestConsecutive3(arr));
    }
}