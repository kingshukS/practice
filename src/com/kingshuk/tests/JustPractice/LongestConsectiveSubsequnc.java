package com.kingshuk.tests.JustPractice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsectiveSubsequnc {

    static int longestSeq(int[] arr)
    {
        Set<Integer> set = new HashSet<>();
        int res= 0;
        for(int i = 0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }

        for(int i = 0;i<arr.length;i++)
        {

            if(!set.contains(arr[i]-1)) {
                int j = arr[i];
                while (set.contains(j)) {
                    j++;
                }

                if (res < j - arr[i]) {
                    res = j - arr[i];
                }
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] arr = {1, 9, 3, 10, 4, 5, 2};
        System.out.println(longestSeq(arr));
    }
}
