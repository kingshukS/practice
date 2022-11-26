package com.kingshuk.tests.hundredDaysChallenge.day13;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * <p>
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * <p>
 * Solution: power of 2's = b01, b10, b100, b1000, b10000 and so on. and power of 2 - 1 = b00, b01, b011, b0111 sna so on, doing '&' will produce 0.
 */
class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}