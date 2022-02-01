package com.kingshuk.tests.DynamicProgramming;

public class EggDroppingPuzzle {
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    static int trials(int eggs,int floors)
    {
        int t[][] = new int[eggs+1][floors+1];
        int res;
        for (int i =1;i<=eggs;i++)
        {
            t[i][0] = 0;
            t[i][1] = 1;
        }
        for (int j =1;j<=floors;j++)
        {
            t[0][j] = 0;
            t[1][j] = j;
        }

        for (int i =2;i<=eggs;i++) { //loop for eggs
            for (int j = 2; j <= floors; j++) { //loop for floor
                    t[i][j] = Integer.MAX_VALUE;
                for(int k = 1;k<=j;k++) { //loop for current floor from 0th floor
                    res = 1+max(t[i - 1][k - 1], t[i][j - k]);
                    if(res<t[i][j])
                    {
                        t[i][j] = res;
                    }
                }
            }
        }
        return t[eggs][floors];
    }
    public static void main(String args[])
    {
        int eggs = 2;
        int floors = 10;
        System.out.println(trials(eggs,floors));
    }
}
