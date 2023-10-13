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
    public static int partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++){
            for(int j = 0; j<=i; j++)
            {
                if(s.charAt(i) == s.charAt(j) && (i-j<=2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        return minPalindromicPartitionsRecursive( 0, s.length()-1,dp);
    }

    private static int minPalindromicPartitionsRecursive( int i, int j, boolean[][] dp) {
        if (i >= j || dp[i][j])
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = dp[i][k]? 0 : minPalindromicPartitionsRecursive(i, k, dp);
            temp += dp[k + 1][j]?0 : minPalindromicPartitionsRecursive(k + 1, j, dp);
            min = Math.min(temp + 1, min);
        }
        return min;
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
                boolean charEquals = str.charAt(i) == str.charAt(j);
                if (L == 2)
                    p[i][j] = charEquals;
                else
                    p[i][j] = (charEquals && p[i + 1][j - 1]);
                if (p[i][j])
                    t[i][j] = 0;
                else{
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
