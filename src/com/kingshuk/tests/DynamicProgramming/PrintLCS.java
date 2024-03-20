package com.kingshuk.tests.DynamicProgramming;


public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int n = s1.length();
        int m = s2.length();
        System.out.println("the longest length of substring is : " + longestCommonSubsequence(s1, s2, n, m));
    }

    private static String longestCommonSubsequence(String s1, String s2, int n, int m) {
        int[][] t = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m; j++){
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
        char[] lcs = new char[t[n][m]];
        int index = lcs.length - 1;
        int i = n, j = m;
        // index ends, becomes -1 when any of i or j becomes 0
        while(index>=0)
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
