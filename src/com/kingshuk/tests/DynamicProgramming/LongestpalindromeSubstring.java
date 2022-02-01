package com.kingshuk.tests.DynamicProgramming;

public class LongestpalindromeSubstring {
    static String reverse(String a)
    {
        char[] b = a.toCharArray();
        String rev="";
        for (int i = b.length-1; i>=0; i--)
             rev  += b[i];

        return rev;
    }

    static int longestPalin(char[] s1,char[] s2,int n ,int m)
    {
        int t[][] = new int[n+1][m+1];
        int res = 0;
        for(int i = 0;i<=n;i++)
        {
            for(int j =0;j<=m;j++)
            {
               if(i==0 || j==0)
                t[i][j] = 0;
            }
        }

        for(int i = 1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                if(s1[i-1] == s2[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                    res = Math.max(t[i][j],res);
                }
                else
                    t[i][j] = 0;
            }
        }

        return res;
    }
    public static void main(String args[])
    {
        String a = "forgeeksskeegfor";
        String b = reverse(a);
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int n = a.length();
        int m = a.length();
        System.out.println("Length of longest palindrome sunstring is : "+longestPalin(a1,b1,n,m));

    }
}
