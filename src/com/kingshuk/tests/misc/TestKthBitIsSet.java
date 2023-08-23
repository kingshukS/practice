package com.kingshuk.tests.misc;

public class TestKthBitIsSet {
    public static void main(String[] args) {
        int k = 6;
        int n = 32;
        System.out.printf("%dth bit of %d is set = ",k,n);
        System.out.println(findIfSetBit(n,k));
    }

    private static boolean findIfSetBit(int n, int k) {
        int factor = (int)Math.pow(2,k-1);
        int result = n & factor;
        return result!=0;
    }
}
