package com.kingshuk.tests.Arrays;

public class SubsetSumProblem {
    static boolean compare(boolean a,boolean b){
        return a || b;
    }
    static boolean isSubsetpresent(int[] arr, int sum, int length)
    {
        boolean[][] t = new boolean[length+1][sum+1];
        int i,j;
        for(i = 0;i<=length;i++)
        {
            for(j=0;j<=sum;j++)
            {
                if(i==0)
                t[i][j] = false;
                if(j==0)
                {
                    t[i][j] = true;
                }
            }
        }

        for(i =1;i<=length;i++)
        {
            for(j=1;j<=sum;j++)
            {
                if(arr[i-1]>j)
                {
                    t[i][j] = t[i-1][j];
                }
                t[i][j] = compare(t[i-1][j] , t[i-1][j]);
            }
        }
        return t[length][sum];
    }
    public static void main(String[] args)
    {
        int[] arr ={3, 34, 4, 12, 5, 2};
        int sum = 9;
        int length = arr.length;
        if(isSubsetpresent(arr,sum,length))
        {
            System.out.print("The subset is present for this sum");
        }
        else
        {
            System.out.print("No subset present for this sum");
        }
    }
}
