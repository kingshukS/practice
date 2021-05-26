package com.kingshuk.tests;

public class TestTrailingZeroesInFactorial {
    public static void main(String[] args) {
        System.out.println(isFactTrailingZeroes1(251));
    }

    private static int isFactTrailingZeroes(int n) {

        int numFive = 0;

        for(int i = 1; i<=n; i++) {
            if(i%5==0){
                int n1 = i;
                while(n1%5==0){
                    System.out.println("For i:"+i);
                    numFive+=1;
                    n1=n1/5;
                }
            }
        }
        return numFive;
    }

    private static int isFactTrailingZeroes1(int n) {

        int numFive = 0;
        int n1 = n;
        while(n1/5>0)
        {
            numFive+=n1/5;
            n1=n1/5;
        }
        return numFive;
    }
}
