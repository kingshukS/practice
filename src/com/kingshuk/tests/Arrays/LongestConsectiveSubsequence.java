package com.kingshuk.tests.Arrays;

import java.util.HashSet;

public class LongestConsectiveSubsequence {

    static int subsequence(int arr[])
    {
        int ans=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int k=0;k<arr.length;k++)
        {
            hs.add(arr[k]);
        }
        for(int i =0;i<arr.length;i++)
        {
            if(!hs.contains(arr[i]-1))
            {
                int j = arr[i];

                while(hs.contains(j))
                {
                    j++;
                }
                if(ans<j-arr[i])
                {
                    ans = j-arr[i];
                }
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};

        System.out.print(subsequence(arr));
    }
}
