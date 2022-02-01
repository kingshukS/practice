package com.kingshuk.tests.DynamicProgramming;

public class LongestCommonSubstring {

    static int longestSubSeqlength(char[] x,char[] y,int n ,int m)
    {
        int t[][] = new int[n+1][m+1];
        int result = 0;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(i == 0 || j==0) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                    t[i][j] =  0;

                if(x[i-1] == y[j-1]){
                    t[i][j] =   1 + t[i-1][j-1];
                    result = Math.max(result,t[i][j]);}
                else
                  t[i][j] = 0;
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        String s1 = "ABCDGH";
        String s2 = "ABDFHR";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int n = x.length;
        int m = y.length;
        System.out.println("the longest length of substring is : "+longestSubSeqlength(x,y,n,m));
    }
}
