package com.kingshuk.tests.hundredDaysChallenge.day11;

public class ReverseWordsInAString {
    public static void main ( String[] args ) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString ();
        System.out.println ( reverseWordsInAString.reverseWords ( "Let's take LeetCode contest" ) );
    }

    public String reverseWords ( String s ) {
        char[] chars = s.toCharArray ();
        int lastSpaceIndex = - 1;
        for ( int i = 0; i < chars.length; i++ ) {
            if ( chars[i] == ' ' ) {
                reverse ( chars, lastSpaceIndex + 1, i - 1 );
                lastSpaceIndex = i;
            }
        }
        reverse ( chars, lastSpaceIndex + 1, chars.length - 1 );
        return new String ( chars );
    }

    private void reverse ( char[] chars, int begin, int end ) {
        int left = begin;
        int right = end;
        while (left < right) {
            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
        }
    }
}
