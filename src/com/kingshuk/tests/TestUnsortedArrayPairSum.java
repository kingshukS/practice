package com.kingshuk.tests;

import java.util.HashSet;
import java.util.Set;

public class TestUnsortedArrayPairSum {
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8,12 };
        int n = 16;
        printpairs(A, n);
    }

    private static void printpairs(int[] a, int n) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : a){
            if(set.contains(n-i)){
                System.out.println("["+i+","+(n-i)+"]");
            }
            set.add(i);
        }
    }
}
