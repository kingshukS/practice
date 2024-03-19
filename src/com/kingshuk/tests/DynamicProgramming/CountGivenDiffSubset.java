package com.kingshuk.tests.DynamicProgramming;

public class CountGivenDiffSubset {

    static int subsetCount(int[] arr, int n, int sumCount)
    {
        int i,j;
        int[][] t = new int[n+1][sumCount+1];
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=sumCount;j++) {
                if(i==0)
                {
                    t[i][j] = 0;
                }
                if(j==0)
                {
                    t[i][j] = 1;
                }
            }
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=sumCount;j++)
            {
                if(arr[i-1]>j)
                {
                    t[i][j] = t[i-1][j];
                }
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
            }
        }
        return t[n][sumCount];
    }
    static int countGivenDiff(int[] arr, int n, int diff)
    {
        int sum = 0;
        int sumCount;
        for(int i = 0;i<n;i++)
        {
            sum = sum+arr[i];
        }
        int x = (sum + diff);
		if(x < 0 || x%2 == 1) return 0;
        int ans = subsetCount(arr,n,x/2);
        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,1,2,3};
        int n = arr.length;
        int diff = 1;
        int ans = countGivenDiff(arr,n,diff);
        System.out.println("The count of subsets is "+ans);
    }
}
