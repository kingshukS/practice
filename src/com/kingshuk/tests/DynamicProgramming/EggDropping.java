package com.kingshuk.tests.DynamicProgramming;

public class EggDropping {


    static int minFloors(int eggs,int floors)
    {
        int t[][] = new int[eggs+1][floors+1];
        int i,j;
        int res = Integer.MAX_VALUE;
        for(i = 1;i<=eggs;i++)
        {
            t[i][0] = 0;
            t[i][1] = 1;
        }

        for(j =1;j<=floors;j++)
        {
            t[1][j] = j;
        }

        for(i = 2;i<=eggs;i++) {
            for (j = 2; j <= floors; j++) {
                t[i][j] = Integer.MAX_VALUE;
                for(int k =1;k<=j;k++)
                {
                    res = 1+ Math.max(t[i-1][k-1],t[i][j-k]); //max between whether egg broke or not
                    if(res < t[i][j])
                    {
                        t[i][j] = res ;
                    }
                }

            }
        }
        return t[eggs][floors];
    }
    public static void main(String args[])
    {
        int eggs = 2;
        int floors = 36;
        System.out.print(minFloors(eggs,floors));
    }
}
