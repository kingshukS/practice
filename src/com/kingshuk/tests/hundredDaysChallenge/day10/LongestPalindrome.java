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
        if(s.length() <= 1)
            return s.length();

        int[] arr = new int[128];
        for(char c : s.toCharArray())
        {
            arr[c]++;
        }
        int sum = 0, odd_count = 0;
        for(int i = 0; i<128; i++)
        {
            if(arr[i] %2 == 0)
                sum+=arr[i];
            else{
                sum+=arr[i] - 1;
                odd_count++;
            }
        }
        return odd_count>0?sum+1:sum;
    }
}
