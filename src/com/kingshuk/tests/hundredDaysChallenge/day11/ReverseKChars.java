package com.kingshuk.tests.hundredDaysChallenge.day11;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 * <p>
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and leave the other as original.
 */
public class ReverseKChars {
    public static void main ( String[] args ) {
        ReverseKChars reverse = new ReverseKChars ();
        System.out.println ( reverse.reverseStr ( "abcdefghijklmn", 3 ) );
    }

    public String reverseStr ( String s, int k ) {
        char[] stringInAction = s.toCharArray ();
        int n = stringInAction.length;
        for ( int i = 0; i < n; i = i + 2 * k ) {
            if ( i + k < n ) {
                reverse ( stringInAction, i, i + k - 1 );
            } else {
                reverse ( stringInAction, i, n - 1 );
            }
        }
        return new String ( stringInAction );
    }

    private void reverse ( char[] stringInAction, int begin, int end ) {
        if ( begin < end ) {
            int left = begin, right = end;
            while (left < right) {
                char t = stringInAction[left];
                stringInAction[left] = stringInAction[right];
                stringInAction[right] = t;
                left++;
                right--;
            }
        }
    }
}
