package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome1 {
    public static void main(String[] args) {
        ValidPalindrome1 validPalindrome = new ValidPalindrome1();
        String s = "A man, a plan, a canal1: Panama";
        System.out.println(validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
