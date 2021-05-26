package com.kingshuk.tests;

public class TestTowerOfHanoi {
    static int step = 0;
    public static void main(String[] args) {
        char A = 'A';
        char B = 'B';
        char C = 'C';
        int n = 4;
        printTOHSteps(n,A,C,B);
        System.out.println("\n\nTotal Steps:"+step);
    }

    private static void printTOHSteps(int n, char A, char C, char B) {
        if(n==1)
        {
            step++;
            System.out.println("Move disc "+n+" from "+A+" to "+C);
            return;
        }
        printTOHSteps(n-1,A,B,C);
        System.out.println("Move disc "+n+" from "+A+" to "+C);
        step++;
        printTOHSteps(n-1,B,C,A);
    }
}
