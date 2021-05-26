package com.kingshuk.tests;

import java.util.Arrays;

public class TestRopeCuttingProblem {
    private static final int INFINITY = Integer.MIN_VALUE;
    private static int[] t;
    public static void main(String[] args) {
        int n = 23;
        int a = 12;
        int b = 9;
        int c = 12;
        System.out.println(findMaxCuts(n,a,b,c));
    }

    private static int findMaxCuts(int n, int a, int b, int c) {
        t = new int[n+1];
        Arrays.fill(t,-1);
        int res = findMaxCut(n,a,b,c);
        if(res<0)
            return -1;
        return res;
    }

    private static int findMaxCut(int n, int a, int b, int c) {
        if(n<0)
            return INFINITY;
        if(n==0)
            return 0;
        int x,y,z;
        // value for x
        if(n-a>0 && t[n-a]!=-1)
            x = t[n-a];
        else {
            x = findMaxCut(n - a, a, b, c);
            if(n-a>0)
                t[n - a] = x;
        }
        // value for y
        if(n-b>0 && t[n-b]!=-1)
            y = t[n-b];
        else {
            y = findMaxCut(n - b, a, b, c);
            if(n-b>0)
                t[n - b] = y;
        }
        // value for z
        if(n-c>0 && t[n-c]!=-1)
            z = t[n-c];
        else {
            z = findMaxCut(n - c, a, b, c);
            if(n-c>0)
                t[n - c] = z;
        }
        return t[n]=1+Math.max(Math.max(x,y),z);
    }
}
