package com.kingshuk.tests.recursion;

public class Palindrome {
    public static void main ( String[] args ) {
        String s = "MADAM";
        System.out.println ( isPalindrome ( s, 0, s.length () - 1 ) );
        System.out.println ( isPalindrome ( s, 0 ) );
    }

    private static boolean isPalindrome ( String s, int i ) {
        if ( i >= s.length () / 2 )
            return true;
        if ( s.charAt ( i ) != s.charAt ( s.length () - 1 - i ) )
            return false;
        return isPalindrome ( s, i + 1 );
    }

    private static boolean isPalindrome ( String s, int l, int r ) {
        if ( l >= r )
            return true;
        if ( s.charAt ( l ) != s.charAt ( r ) )
            return false;
        return isPalindrome ( s, l + 1, r - 1 );
    }
}
