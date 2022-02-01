package com.kingshuk.tests.DynamicProgramming;

public class LCSString{

    static void longestSubSeqlength(char[] x,char[] y,int n ,int m)
    {
        int t[][] = new int[n+1][m+1];

        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(i == 0 || j==0) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                    t[i][j] =  0;

                if(x[i-1] == y[j-1])
                    t[i][j] =   1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
            }
        }

        int index = t[m][n]; //storing full iteration result in t
        int temp = index; //storing index value in temp
        char[] lcs = new char[index+1];
        int i = n,j = m;
        while(i>0 && j>0) {
            if (x[i - 1] == y[j - 1]) {
                lcs[index - 1] = x[i - 1];
                i--;
                j--;
                index--;
            } else if (t[i - 1][j] > t[i][j - 1])
                i--;
            else
                j--;

        }

        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);
    }

    public static void main(String args[])
    {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int n = x.length;
        int m = y.length;
        longestSubSeqlength(x,y,n,m);
    }
}
