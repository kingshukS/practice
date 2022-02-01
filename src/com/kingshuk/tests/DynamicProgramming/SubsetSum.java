package com.kingshuk.tests.DynamicProgramming;

public class SubsetSum {

    static boolean subSetProb(int arr[],int sum,int n)
    {
        boolean t[][] = new boolean[n+1][sum+1];
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=sum;j++)
            {
                if(i==0) //if elements are null
                {
                    t[i][j] = false;
                }
                if(j==0) //if sum is 0 then null subset can be used to make 0
                {
                    t[i][j] = true;
                }
            }

            for(i=1;i<=n;i++)
            {
                for(j=1;j<=sum;j++)
                {
                    if(arr[i-1] > j)
                    {
                        t[i][j] = t[i-1][j];
                    }
                    else
                    {
                        t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                    }
                }
            }
        }


        return t[n][sum];
    }
    public static void main(String args[])
    {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 3;
        int n = arr.length;
        boolean ans = subSetProb(arr,sum,n);
        if(ans)
        {
            System.out.println("Subset is possible ");
        }
        else
        {
            System.out.println("Subset is not possible ");
        }
    }

}
