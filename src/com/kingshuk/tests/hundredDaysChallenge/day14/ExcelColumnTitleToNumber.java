package com.kingshuk.tests.hundredDaysChallenge.day14;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet,
 * return its corresponding column number.
 */
class ExcelColumnTitleToNumber {
    public int titleToNumber ( String s ) {
        if ( s.length () == 1 ) return s.charAt ( 0 ) - 'A' + 1;
        int pow = 1, sum = 0;
        for ( int i = s.length () - 1; i >= 0; i-- ) {
            char c = s.charAt ( i );
            sum += ( c - 'A' + 1 ) * pow;
            pow *= 26;
        }
        return sum;
    }
}