package com.kingshuk.tests;

public class TestRecursivePower {

    public static void main(String[] args) {
        System.out.println("Result is : "+ findRecursivePower(5,4));
    }

    private static long findRecursivePower(int x, int n) {

        if(n == 0){
            return 1L;
        }

        long temp = findRecursivePower(x,n/2);

        if(n%2 == 0){
            return temp*temp;
        }else{
            return temp*temp*x;
        }
    }
}
