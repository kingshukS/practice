package com.kingshuk.tests.misc;

import java.util.Arrays;

public class TestFibonacciDP {
    public static void main(String[] args) {
        System.out.println(Solution.fibonacci(5));
    }
}
class Solution
{
    static int f[];
    static int fibonacci(int n)
    {
        f = new int[n+1];
        Arrays.fill(f,-1);
        f[0] = 0;
        f[1] = 1;

        return fibonacci2(n);
    }
    static int fibonacci2(int n)
    {
        // your code here
        if(n == 0 || n==1)
            return f[n];

        int x = 0;
        int y = 0;

        if(f[n-1]!=-1)
            x = f[n-1];
        else
            x = f[n-1] = fibonacci2(n-1);

        if(f[n-2]!=-1)
            y = f[n-2];
        else
            y = f[n-2] = fibonacci2(n-2);

        return f[n] = (x+y);
    }
}
