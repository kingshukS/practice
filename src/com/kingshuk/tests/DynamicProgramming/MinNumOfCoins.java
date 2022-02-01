package com.kingshuk.tests.DynamicProgramming;

public class MinNumOfCoins {


    static int minNumCoins(int coins[],int n,int sum)
    {
        int t[][] = new int[n+1][sum+1];


        int j=1;

        for(int i = 0;i<=n;i++)
        {
            for(int k = 0;k<=sum;k++)
            {

                if(i==0)
                {
                    t[0][k] = Integer.MAX_VALUE -1;
                }

                if(k==0)
                {
                    t[i][0] = 0;
                }

                if(i==0 && k==0)
                {
                    t[i][k] = Integer.MAX_VALUE -1;
                }
            }
        }
            for(int i =1;j <=sum;j++)
        {
            if(j%coins[0] == 0)
            {
                t[i][j] = j/coins[0];
            }
            else {
                t[i][j] = Integer.MAX_VALUE-1;
            }
        }

            for(int i = 2;i<=n;i++)
            {
                for(int k = 1;k<=sum;k++)
                {
                    if(coins[i-1]>k)
                    {
                        t[i][k] = t[i-1][k];
                    }
                    else
                        t[i][k] = Math.min(1 + t[i][k-coins[i-1]],
                                                t[i-1][k]);
                }
            }

         return t[n][sum];
    }
    public static void main(String args[])
    {
        int coins[] = {1,3,5};
        int n = coins.length;
        int sum = 9;
        System.out.println("the min number of coins req is : "+minNumCoins(coins,n,sum));
    }
}
