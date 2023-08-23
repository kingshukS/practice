package com.kingshuk.tests.misc;

public class TestSumOfDigitsRecursion {
    public static void main(String[] args) {
        int n = 2530;
        System.out.println(findSumOfDigits(n));
    }

    private static int findSumOfDigits(int n) {
        if(n<=0)
            return 0;
        return (n%10) + findSumOfDigits(n/10);
    }
}
