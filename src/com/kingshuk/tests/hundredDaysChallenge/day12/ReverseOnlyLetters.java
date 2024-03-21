package com.kingshuk.tests.hundredDaysChallenge.day12;

public class ReverseOnlyLetters {
    public static void main ( String[] args ) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters ();
        System.out.println ( reverseOnlyLetters.reverseOnlyLetters ( "7_28]" ) );
    }

    public String reverseOnlyLetters ( String s ) {
        char[] chars = s.toCharArray ();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && ! ( ( chars[left] >= 'a' && chars[left] <= 'z' ) || ( chars[left] >= 'A' && chars[left] <= 'Z' ) ))
                left++;
            while (left < right && ! ( ( chars[right] >= 'a' && chars[right] <= 'z' ) || ( chars[right] >= 'A' && chars[right] <= 'Z' ) ))
                right--;
            if ( left < right ) {
                char t = chars[right];
                chars[right] = chars[left];
                chars[left] = t;
                left++;
                right--;
            }
        }
        return new String ( chars );
    }
}
