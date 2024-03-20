package com.kingshuk.tests.DynamicProgramming;

// Old code
public class EditDistanceProblemUsing1D {

    static int findEditDistance(String s1, String s2, int m, int n) {
        int[][] t = new int[2][n + 1];
        int bi = 0;
        for (int i = 0; i <= m; i++) {
            bi = i & 1;
            for (int j = 0; j <= n; j++) {
                if (i == 0) //this means if the length of 1st strings is 0 then result will be the length of the other string (all insertion)
                    t[bi][j] = j;
                else if(j == 0) //this means if the length of 2nd strings is 0 then result will be the length of the other string (all deletion)
                    t[bi][j] = i;
                else {
                    if (s1.charAt(i-1) == s2.charAt(j-1))
                        t[bi][j] = t[1 - bi][j - 1];
                    else
                        t[bi][j] = 1 + Math.min(Math.min(t[bi][j - 1], t[1 - bi][j]),t[1 - bi][j-1]);
                }
            }
        }
        return t[bi][n];
    }

    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "CUT";
        System.out.println("the edit distance operation required is : " + findEditDistance(s1, s2, s1.length(), s2.length()));
    }
}
