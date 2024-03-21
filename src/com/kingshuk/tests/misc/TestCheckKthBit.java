package com.kingshuk.tests.misc;

public class TestCheckKthBit {
    public static void main ( String[] args ) {
        System.out.println ( CheckBit.checkKthBit ( 39, 5 ) );
    }
}

class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit ( int n, int k ) {
        // Your code here
        return ( ( n >> k ) & 1 ) != 0;
    }

}
