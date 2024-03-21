package com.kingshuk.tests.hundredDaysChallenge.day13;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class MathSqrt {
    public int mySqrt ( int x ) {
        long low = 0, high = x, ans = 0;
        while (low <= high) {
            long mid = ( low + high ) / 2;
            if ( mid * mid < x ) {
                low = mid + 1;
                ans = mid;
            } else if ( mid * mid > x ) {
                high = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int) ans;
    }
}
