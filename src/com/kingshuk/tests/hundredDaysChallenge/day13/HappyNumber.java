package com.kingshuk.tests.hundredDaysChallenge.day13;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public static void main ( String[] args ) {
        System.out.println ( new HappyNumber ().isHappy ( 2 ) );
    }

    public boolean isHappy ( int n ) {
        Set<Integer> set = new HashSet<> ();
        while (true) {
            int res = squareDigits ( n );
            if ( res == 1 )
                return true;
            else if ( set.contains ( res ) )
                return false;
            set.add ( res );
            n = res;
        }
    }

    private int squareDigits ( int n ) {
        int sum = 0;
        while (n > 0) {
            sum += ( n % 10 ) * ( n % 10 );
            n = n / 10;
        }
        return sum;
    }
}
