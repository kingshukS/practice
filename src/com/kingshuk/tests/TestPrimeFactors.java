package com.kingshuk.tests;

import java.util.ArrayList;
import java.util.List;

public class TestPrimeFactors {
    public static void main(String[] args) {
        int x = 100;
        System.out.println("Prime factors of N are: "+findPrimeFactors(x));
    }

    private static List<Integer> findPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        if(n<=1)
            return list;

        while(n%2==0){
            list.add(2);
            n = n/2;
        }

        while(n%3==0){
            list.add(3);
            n = n/3;
        }

        for(int i = 5; i*i<=n; i=i+6){
            while(n%i==0){
                list.add(i);
                n = n/i;
            }
            while(n%(i+2)==0){
                list.add(i+2);
                n = n/(i+2);
            }
        }

        if(n>3)
            list.add(n);

        return list;
    }
}
