package com.kingshuk.tests.hundredDaysChallenge.day15;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 */
public class HammingDistance {
    public int hammingDistance ( int x, int y ) {
        // XOR gives the total bit differences
        int xor = x ^ y;
        int diff = 0;
        // Need to calculate the number of 1's in XOR
        while (xor > 0) {
            diff += ( xor & 1 );
            xor >>= 1;
        }
        return diff;
    }
}
