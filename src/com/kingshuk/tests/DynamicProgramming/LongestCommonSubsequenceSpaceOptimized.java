package com.kingshuk.tests.DynamicProgramming;

public class LongestCommonSubsequenceSpaceOptimized {

    static int longestSubSeqlength(char[] x, char[] y, int n, int m) {
        int[][] t = new int[2][m + 1];
        int bi = 0;
        for (int i = 0; i <= n; i++) {
            bi = i & 1;
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                    t[bi][j] = 0;
                else {
                    if (x[i - 1] == y[j - 1])
                        t[bi][j] = 1 + t[1 - bi][j - 1];
                    else
                        t[bi][j] = Math.max(t[bi][j - 1], t[1 - bi][j]);
                }
            }
        }
        return t[bi][m];
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int n = x.length;
        int m = y.length;
        System.out.println("the longest length of substring is : " + longestSubSeqlength(x, y, n, m));
    }
}
