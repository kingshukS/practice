package com.kingshuk.tests.DynamicProgramming;

public class PrintSCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        System.out.println("the longest length of substring is : " + findShortestCommonSuperSequence(s1, s2, m, n));
    }

    private static String findShortestCommonSuperSequence(String s1, String s2, int m, int n) {
        int[][] t = new int[m+1][n+1];
        String scs = "";
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0)
                {
                    t[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i = m, j = n;
        while(i!=0 && j != 0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                scs += s1.charAt(i-1);
                i--;
                j--;
            }else if(t[i-1][j]>t[i][j-1]){
                scs += s1.charAt(i-1);
                i--;
            }else{
                scs += s2.charAt(j-1);
                j--;
            }
        }
        while(i>0)
        {
            scs += s1.charAt(i-1);
            i--;
        }
        while(j>0)
        {
            scs += s2.charAt(j-1);
            j--;
        }
        return new StringBuilder().append(scs).reverse().toString();
    }
}
