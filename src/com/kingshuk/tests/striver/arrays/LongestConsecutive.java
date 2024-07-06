package com.kingshuk.tests.striver.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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

        int maxCount = 0;
        for(int x : nums){
            if(!numSet.contains(x-1)){
                int count = 1;
                while(numSet.contains(x+1))
                {
                    count++;
                    x++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        
        return maxCount;
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