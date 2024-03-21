package com.kingshuk.tests.hundredDaysChallenge.day13;

public class IsPalindrome {
    public static void main ( String[] args ) {
        System.out.println ( new IsPalindrome ().isPalindrome ( - 525 ) );
    }

    public boolean isPalindrome ( int x ) {
        int n = x;
        int sum = 0;
        while (x != 0) {
            int r = x % 10;
            sum = sum * 10 + r;
            x = x / 10;
        }
        return n == sum;
    }
}
