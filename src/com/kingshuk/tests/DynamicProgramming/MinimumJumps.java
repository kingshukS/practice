package com.kingshuk.tests.DynamicProgramming;

public class MinimumJumps {

    static int minJumpsRequired(int arr[])
    {
        int n = arr.length;
        int i,j;
        int jumps[] = new int[n];

        if(n==0 || arr[0]==0)
        {
            return Integer.MAX_VALUE;
        }
        jumps[0] = 0;
        for(i=1;i<n;i++)
        {
            jumps[i] = Integer.MAX_VALUE;
            for(j=0;j<i;j++)
            {
                if(i<=j+arr[j] && jumps[j] != Integer.MAX_VALUE)
                {
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                    break;
                }
            }

        }
            return jumps[i-1];
    }
    public static void main(String args[])
    {
        int arr[]={1, 3, 6, 1, 0, 9};
        System.out.println("Minimum jumps required "+minJumpsRequired(arr));

    }
}
