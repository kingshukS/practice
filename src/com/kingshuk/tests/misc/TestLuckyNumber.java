package com.kingshuk.tests.misc;

public class TestLuckyNumber {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(isLucky(n));
    }
    public static boolean isLucky(int n)
    {
        // initialize counter, can be taken as static variable as well
        int counter = 2;

        return findIfLucky(n,counter);
    }
    private static boolean findIfLucky(int n, int counter)
    {
        if(counter>n){
            return true;
        }
        if(n % counter == 0)
            return false;

        n = n - n/counter;

        return findIfLucky(n,counter+1);
    }
}
