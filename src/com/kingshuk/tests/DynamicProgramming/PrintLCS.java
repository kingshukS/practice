package com.kingshuk.tests.DynamicProgramming;


public class PrintLCS {
    public static void main(String args[]) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int m = s1.length();
        int n = s2.length();
        System.out.println("the longest length of substring is : " + longestCommonSubsequence(s1, s2, m, n));
    }

    private static String longestCommonSubsequence(String s1, String s2, int m, int n) {
        int[][] t = new int[m+1][n+1];
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
        char[] lcs = new char[t[m][n]];
        int index = lcs.length - 1;
        int i = m, j = n;
        while(i!=0 && j != 0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                lcs[index--] = s1.charAt(i-1);
                i--;
                j--;
            }else if(t[i-1][j]>t[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return new String(lcs);
    }
}
