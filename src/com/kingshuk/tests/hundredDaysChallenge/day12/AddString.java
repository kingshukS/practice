package com.kingshuk.tests.hundredDaysChallenge.day12;

public class AddString {
    public static void main ( String[] args ) {
        System.out.println ( new AddString ().addStrings2 ( "99", "199" ) );
    }

    public String addStrings ( String num1, String num2 ) {
        int carry = 0;
        int i = num1.length () - 1;
        int j = num2.length () - 1;
        StringBuilder res = new StringBuilder ();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += i >= 0 ? num1.charAt ( i-- ) - '0' : 0;
            sum += j >= 0 ? num2.charAt ( j-- ) - '0' : 0;
            carry = sum / 10;
            res.append ( sum % 10 );
        }
        if ( carry != 0 )
            res.append ( carry );
        return res.reverse ().toString ();
    }

    public String addStrings2 ( String num1, String num2 ) {
        if ( num1.length () < num2.length () ) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int remainder = 0;
        StringBuilder sb = new StringBuilder ();
        int num1Ptr = num1.length () - 1;

        for ( int i = num2.length () - 1; i >= 0; i-- ) {
            int digit = ( num1.charAt ( num1Ptr ) - '0' ) + ( num2.charAt ( i ) - '0' ) + remainder;
            sb.append ( (char) ( digit % 10 + '0' ) );
            remainder = digit / 10;
            num1Ptr--;
        }

        for ( int i = num1Ptr; i >= 0; i-- ) {
            int digit = ( num1.charAt ( i ) - '0' ) + remainder;
            sb.append ( (char) ( digit % 10 + '0' ) );
            remainder = digit / 10;
        }

        if ( remainder != 0 ) {
            sb.append ( (char) ( remainder + '0' ) );
        }
        return sb.reverse ().toString ();
    }
}
