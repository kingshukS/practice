package com.kingshuk.tests.misc;

public class TestJosepheusProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println(findLastSurvival(n,k));
    }

    // for 0 based indexing
    // we have to map and offset to findLastSurvival(n-1,k) to get the expected result as index
    // will be changed after a person is killed and mapping would be different in that case.
    // time complexity = theta(n)
    private static int findLastSurvival(int n, int k) {
        if(n == 1)
            return 0;
        return (findLastSurvival(n-1,k)+k)%n;
    }
}
