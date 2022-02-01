package com.kingshuk.tests.DynamicProgramming;

public class CountOfSubset {

    static int countSubset(int arr[],int sum,int n)
    {
        int t[][] = new int[n+1][sum+1];
        int i,j;
        for(i = 0;i<=n;i++)
        {
            for(j=0;j<=sum;j++)
            {
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
        for(i = 1;i<=n;i++) {
            for (j = 1; j <= sum; j++) {
                if(arr[i-1]>j)
                {
                    t[i][j] = t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 3};
        int sum = 3;
        int n = arr.length;
        int ans = countSubset(arr,sum,n);
        System.out.println("Count of subset is "+ans);
    }
}
