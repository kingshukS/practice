package com.kingshuk.tests.DynamicProgramming;

public class LongestIncreasingSubsequence {
    static int longestLength(int arr[] , int n)
    {
        int i ,j,max = 0;
        int length[] = new int[n+1];

        for(i = 0;i<n;i++)
        {
            length[i] = 1;
        }

        for(i = 0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && length[i] < length[j]+1)
                {
                    length[i] = length[j]+1;
                }
            }
        }

        for(i = 0;i<n;i++)
        {
            if(max < length[i])
            {
                max = length[i];
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;
        System.out.println("Longest increasing subsequence is : "+longestLength(arr,n));
    }
}
