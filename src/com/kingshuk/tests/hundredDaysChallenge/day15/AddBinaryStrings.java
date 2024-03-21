package com.kingshuk.tests.hundredDaysChallenge.day15;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinaryStrings {
    public String addBinary ( String a, String b ) {
        int carry = 0, i = a.length () - 1, j = b.length () - 1;
        StringBuilder res = new StringBuilder ();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += i < 0 ? 0 : a.charAt ( i-- ) - '0';
            sum += j < 0 ? 0 : b.charAt ( j-- ) - '0';
            res.append ( sum % 2 );
            carry = sum > 1 ? 1 : 0;
        }
        if ( carry != 0 )
            res.append ( carry );
        return res.reverse ().toString ();
    }
}
