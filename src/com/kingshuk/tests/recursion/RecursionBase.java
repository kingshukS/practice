package com.kingshuk.tests.recursion;

public class RecursionBase {
    public static void main(String[] args) {
        printNTo1Backtrack( 5);
        print1ToNBacktrack( 5);
        printStringNTimes("Kingshuk", 5);
    }

    private static void printNTo1Backtrack(int n) {
        if( n>0)
        {
            System.out.println(n);
            printNTo1Backtrack( n-1);
        }
    }

    private static void print1ToNBacktrack(int n) {
        if(n == 1)
        {
            System.out.println(n);
            return;
        }
        print1ToNBacktrack( n-1);
        System.out.println(n);

    }

    private static void printStringNTimes(String s, int n){
        if(n > 0) {
            System.out.println(s);
            printStringNTimes(s, n - 1);
        }
    }
}
