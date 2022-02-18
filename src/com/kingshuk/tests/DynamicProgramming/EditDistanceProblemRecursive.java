package com.kingshuk.tests.DynamicProgramming;

public class EditDistanceProblemRecursive {

    static int findEditDistance(String s1, String s2, int m, int n) {
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return findEditDistance(s1, s2, m-1, n-1);
        else
            return 1 + Math.min(Math.min(findEditDistance(s1, s2, m, n-1), findEditDistance(s1, s2, m-1, n)), findEditDistance(s1, s2, m-1, n-1));
    }

    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "CUT";
        System.out.println("the edit distance operation required is : " + findEditDistance(s1, s2, s1.length(), s2.length()));
    }
}
