package com.kingshuk.tests.hundredDaysChallenge.day19;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(new FibonacciSeries().findFibonacci(10));
    }
    public int findFibonacci(int n){
        if(n<=1)
          return n;
        int first = 0;
        int second = 1, sum;
        for(int i = 2; i<= n; i++)
        {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
