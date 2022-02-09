package com.kingshuk.tests.DynamicProgramming;

public class PalindromePartitioningRecursiveDP {
    static int[][] t;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalindromicPartitionsRecursiveUtil(str, 0, str.length() - 1));
        long endTime = System.nanoTime();
        System.out.println("Duration:" + (endTime - startTime));
    }

    private static int minPalindromicPartitionsRecursiveUtil(String str, int start, int end) {
        t = new int[end + 1][end + 1];
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= end; j++) {
                t[i][j] = -1;
            }
        }
        return minPalindromicPartitionsRecursive(str, start, end);
    }

    private static int minPalindromicPartitionsRecursive(String str, int i, int j) {
        if (i >= j || isPalindrome(str, i, j))
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = t[i][k] != -1 ? t[i][k] : minPalindromicPartitionsRecursive(str, i, k);
            temp += t[k + 1][j] != -1 ? t[k + 1][j] : minPalindromicPartitionsRecursive(str, k + 1, j);
            min = Math.min(temp + 1, min);
        }
        return t[i][j] = min;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
