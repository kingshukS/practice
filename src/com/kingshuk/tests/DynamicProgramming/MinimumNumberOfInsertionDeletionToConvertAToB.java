package com.kingshuk.tests.DynamicProgramming;

public class MinimumNumberOfInsertionDeletionToConvertAToB {
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        findMinimumNumberOfInsertionDeletionToConvert(s1, s2);
    }

    private static void findMinimumNumberOfInsertionDeletionToConvert(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        System.out.println("Number of deletion:" + (m - t[m][n]));
        System.out.println("Number of insertion:" + (n - t[m][n]));
    }
}
