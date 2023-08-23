package com.kingshuk.tests.misc;

public class TestIterativePowerFunction {
    public static void main(String[] args) {
        int x = 3;
        int n = 5;
        System.out.println("pow(x,n):"+findPowerOptimizedIterative(x,n));
    }
    //time complexity = O(log n)
    //auxiliary space = O(1)
    private static int findPowerOptimizedIterative(int x, int n) {
        int result = 1;
        if(x==1 || n==0){
            return result;
        }
        if(x==0){
            return 0;
        }
        while(n>0){
            if(n%2==1){
                result = result * x;
            }
            n=n/2;
            x=x*x;
        }
        return result;
    }
}
