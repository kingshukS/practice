package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class ValidPalindrome2 {
    public boolean validPalindrome ( String s ) {
        if ( s.length () == 0 || s.length () == 1 )
            return true;
        int left = 0, right = s.length () - 1;
        while (left <= right) {
            if ( s.charAt ( left ) != s.charAt ( right ) ) {
                return isPalindrome ( s, left + 1, right ) || isPalindrome ( s, left, right - 1 );
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome ( String s, int left, int right ) {
        while (left <= right) {
            if ( s.charAt ( left ) == s.charAt ( right ) ) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
