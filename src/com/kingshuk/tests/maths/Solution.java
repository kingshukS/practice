package com.kingshuk.tests.maths;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean isArmstrong(int n) {
        int pow = (int) (Math.log(n)/ Math.log(10)) + 1;
        int sum = 0, copyN = n;
        while(n!=0)
        {
            int rem = n % 10;
            sum+= (int) Math.pow(rem, pow);
            n = n/10;
        }
        return sum == copyN;
    }

    public static boolean isPerfect(int n) {
        if(n <= 1)
            return false;

        int sqrt = (int) Math.sqrt(n);
        int sum = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isPerfect(28));
    }
}