package com.kingshuk.tests.misc;

public class TestRecursivePowerFunction {
    public static void main(String[] args) {
        int x = 3;
        int n = 5;
        System.out.println("pow(x,n):"+ findPowerOptimizedRecursive(x,n));
    }
    //time complexity = O(log n)
    //auxiliary space = O(log n)
    private static int findPowerOptimizedRecursive(int x, int n) {
        if(x==1 || n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(x==0){
            return 0;
        }
        int temp = findPowerOptimizedRecursive(x,n/2);
        temp = temp * temp;
        if(n%2==1){
            return temp*x;
        }
        return temp;
    }
}
