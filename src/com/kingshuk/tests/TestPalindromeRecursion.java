package com.kingshuk.tests;

public class TestPalindromeRecursion {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(findPalindromeRecursion(s));
    }

    private static boolean findPalindromeRecursion(String s) {
        if (s.length() == 1 || s.length() == 0)
            return true;

        return (s.charAt(0) == s.charAt(s.length() - 1)) && findPalindromeRecursion(s.substring(1, s.length() - 1));
    }
}
