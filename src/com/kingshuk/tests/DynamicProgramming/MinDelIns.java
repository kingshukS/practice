package com.kingshuk.tests.DynamicProgramming;

public class MinDelIns {

    static void minInsDel(char[] a,char[] b,int n,int m)
    {
        int t[][] = new int[n+1][m+1];

        for(int i = 0;i<=n;i++)
        {
            for(int j =0;j<=m;j++)
            {
                if(i==0 || j ==0)
                    t[i][j] = 0;
            }
        }

        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(a[i-1] == b[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
            }
        }
        System.out.println("The number of deletions required : "+ (n - t[n][m]));
        System.out.println("The number of insertions required : "+ (m - t[n][m]));

    }
    public static void main(String args[])
    {
        String s1 = "heap";
        String s2 = "pea";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        minInsDel(a,b,n,m);

    }
}
