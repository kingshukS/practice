package com.kingshuk.tests.DynamicProgramming;

public class ShortestCommonSuperSequence {

    static int shortestCommonSuperSequence(char[] a1,char[] b1,int n ,int m)
    {
       int t[][] = new int[n+1][m+1];
       int totalLen = n+m;
       for(int i = 0;i<=n;i++)
       {
           for(int j = 0;j<=m;j++)
           {
               if(i==0 || j==0)
               {
                   t[i][j] = 0;
               }
           }
       }

        for(int i = 1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                if(a1[i-1] == b1[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
            }
        }

        return totalLen - t[n][m];
    }

    public static void main(String args[])
    {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int n = a.length();
        int m = b.length();
        System.out.println("the shortest common super sequence is : "+shortestCommonSuperSequence(a1,b1,n,m));
    }
}
