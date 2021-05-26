package com.kingshuk.tests;

public class TestGPTerm {

    public static void main(String[] args) {
        System.out.print(termOfGP(84,87,3));
    }
    public static double termOfGP(int A,int B,int N)
    {
        //Your code here
        if(N==1)
            return A;
        if(N==2)
            return B;

        double r = (double)B/(double)A;

        return A*Math.pow(r,N-1);

    }
}
