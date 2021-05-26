package com.kingshuk.tests;

public class TestIterativePower {

    public static void main(String[] args) {
        System.out.println("Result is : "+findIterativePower(5,4));
    }

    private static long findIterativePower(int x, int n) {
        long res = 1L;

        if(n == 0){
            return 1L;
        }

        while(n > 0){

            if(n%2 != 0){
                res = res * x;
            }
            x = x * x;
            n = n/2;
        }
        return res;
    }
}
