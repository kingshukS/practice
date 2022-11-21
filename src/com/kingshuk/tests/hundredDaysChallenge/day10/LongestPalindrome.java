package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

    public static int longestPalindrome(String s) {
        int hash[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int c_e = 0;
        int c_o = 0;
        for (int f : hash) {
            if (f != 0) {
                if (f % 2 == 0) c_e += f;
                else {
                    c_e += f - 1;
                    c_o++;
                }
            }
        }
        return c_e + (c_o > 0 ? 1 : 0);
    }
}
