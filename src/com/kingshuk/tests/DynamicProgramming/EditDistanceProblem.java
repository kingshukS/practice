package com.kingshuk.tests.DynamicProgramming;

public class EditDistanceProblem {

    static int findEditDistance(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                    t[i][j] = j;
                else if(j == 0)
                    t[i][j] = i;
                else {
                    if (s1.charAt(i-1) == s2.charAt(j-1))
                        t[i][j] = t[i - 1][j - 1];
                    else
                        t[i][j] = 1 + Math.min(Math.min(t[i][j - 1], t[i - 1][j]),t[i-1][j-1]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "CUT";
        System.out.println("the edit distance operation required is : " + findEditDistance(s1, s2, s1.length(), s2.length()));
    }
}
