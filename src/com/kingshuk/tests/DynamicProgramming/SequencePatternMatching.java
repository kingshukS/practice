package com.kingshuk.tests.DynamicProgramming;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";
        System.out.println("Does S2 matches with the pattern of S1? "+isPatternMatching(s1, s2));
    }

    private static boolean isPatternMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];

        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0)
                {
                    t[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        if(s1.length() == t[m][n])
            return true;

        return false;
    }
}
