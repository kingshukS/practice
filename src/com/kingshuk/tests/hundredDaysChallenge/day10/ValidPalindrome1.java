package com.kingshuk.tests.hundredDaysChallenge.day10;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome1 {
    public static void main ( String[] args ) {
        ValidPalindrome1 validPalindrome = new ValidPalindrome1 ();
        String s = "A man, a plan, a canal: Panama";
        System.out.println ( validPalindrome.isPalindrome2 ( s ) );
    }

    public boolean isPalindrome ( String s ) {
        if ( s.length () == 0 || s.length () == 1 )
            return true;
        s = s.toLowerCase ().replaceAll ( "[^a-z0-9]", "" );
        int left = 0, right = s.length () - 1;
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

    public boolean isPalindrome2 ( String s ) {
        if ( s.length () <= 1 )
            return true;
        s = s.toLowerCase ();
        int l = 0, r = s.length () - 1;
        while (l < r) {
            while (! ( ( s.charAt ( l ) >= 48 && s.charAt ( l ) <= 57 ) || ( s.charAt ( l ) >= 'a' && s.charAt ( l ) <= 'z' ) ))
                l++;
            while (! ( ( s.charAt ( r ) >= 48 && s.charAt ( r ) <= 57 ) || ( s.charAt ( r ) >= 'a' && s.charAt ( r ) <= 'z' ) ))
                r--;
            if ( s.charAt ( l ) != s.charAt ( r ) )
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
