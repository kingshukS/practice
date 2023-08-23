package com.kingshuk.tests.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSieveOfEratosthenes {
    public static void main(String[] args) {
        int x = 30;
        System.out.println("List of Prime Numbers till N:"+findAllPrimeNumbersTillN(x));
        System.out.println("List of Prime Numbers till N:"+findAllPrimeNumbersTillNV2(x));
    }

    private static List<Integer> findAllPrimeNumbersTillN(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i = 2; i*i<=n; i++){
            if(isPrime[i]){
                int j = i*i;
                while(j<=n){
                   isPrime[j]=false;
                   j = j+i;
                }
            }
        }
        for(int i =2 ; i <= n; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }
        return list;
    }

    private static List<Integer> findAllPrimeNumbersTillNV2(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i = 2; i<=n; i++){
            if(isPrime[i]){
                list.add(i);
                int j = i*i;
                while(j<=n){
                    isPrime[j]=false;
                    j = j+i;
                }
            }
        }
        return list;
    }
}
