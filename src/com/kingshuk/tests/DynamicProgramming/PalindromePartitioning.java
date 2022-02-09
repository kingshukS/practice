package com.kingshuk.tests.DynamicProgramming;

public class PalindromePartitioning {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalindromicPartitions(str, str.length()));
        long endTime = System.nanoTime();
        System.out.println("Duration:" + (endTime - startTime));
    }

    private static int minPalindromicPartitions(String str, int n) {
        int[][] t = new int[n][n];
        boolean[][] p = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            t[i][i] = 0;
            p[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                if (j == n)
                    continue;
                if (L == 2)
                    p[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    p[i][j] = (str.charAt(i) == str.charAt(j) && p[i + 1][j - 1]);
                if (p[i][j])
                    t[i][j] = 0;
                else {
                    t[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int temp = t[i][k] + t[k + 1][j] + 1;
                        t[i][j] = Math.min(t[i][j], temp);
                    }
                }
            }
        }
        return t[0][n - 1];
    }
}
