package com.kingshuk.tests;

import java.util.ArrayList;
import java.util.List;

public class TestAllTheDivisors {
    public static void main(String[] args) {
        int x = 35;
        System.out.println("All divisors of N are: "+findAllTheDivisors(x));
    }

    private static List<Integer> findAllTheDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        for(;i*i<=n; i++){
            if(n%i==0){
                list.add(i);
            }
        }
        for(i=i-1;i>0;i--){
            if(n%i==0){
                list.add(n/i);
            }
        }
        return list;
    }
}
