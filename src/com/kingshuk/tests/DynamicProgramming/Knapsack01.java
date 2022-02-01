package com.kingshuk.tests.DynamicProgramming;

public class Knapsack01 {

    static int knapsack01(int wt[],int value[],int W,int n)
    {
        int t[][] = new int[n+1][W+1];
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=W;j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j] = 0;
                }
            }
        }

        for(i=1;i<=n;i++) {
            for (j = 1; j <= W; j++) {
                    if(wt[i-1]> j)
                    {
                        t[i][j] = t[i-1][j];
                    }
                    else
                    {
                        t[i][j] = Math.max(value[i-1] + t[i-1][j-wt[i-1]],t[i-1][j]);
                    }
            }
        }
        return t[n][W];
    }
    public static void main(String args[])
    {
        int wt[] = { 10, 20, 30 };
        int val[] = { 60, 100, 120 };
        int W = 50;
        int n = val.length;
        System.out.print(knapsack01(wt,val,W,n));
    }
}
