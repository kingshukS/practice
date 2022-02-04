package com.kingshuk.tests.DynamicProgramming;

public class MinimumNumberOfDeletionToMakeAStringPalindrome {
    public static void main(String[] args) {
        String s  = "agbcba";
        int diff = findNumberOfDeletionToMakeItPalindrome(s);
        System.out.println("Minimum number of deletion to make it Palindrome: "+diff);
        System.out.println("Minimum number of insertion to make it Palindrome: "+diff);
    }

    private static int findNumberOfDeletionToMakeItPalindrome(String s) {
        int n = s.length();
        String s1 = new StringBuilder().append(s).reverse().toString();
        int[][] t = new int[n+1][n+1];
        for(int i = 0; i<=n; i++)
        {
            for(int j = 0; j<= n; j++){
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }else if(s.charAt(i - 1) == s1.charAt(j - 1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return n - t[n][n];
    }
}
