package com.kingshuk.tests.DynamicProgramming;

public class LongestCommonSubstring {

    static int longestCommonSubstringLengthRecursive(String x, String y, int index1, int index2, int count) {
        if (index1 < 0 || index2 < 0)
            return count;
        if (x.charAt(index1) == y.charAt(index2)) {
            count = longestCommonSubstringLengthRecursive(x, y, index1 - 1, index2 - 1, count + 1);
        }

        count = Math.max(count, Math.max(longestCommonSubstringLengthRecursive(x, y, index1 - 1, index2, 0),
                longestCommonSubstringLengthRecursive(x, y, index1, index2 - 1, 0)));
        return count;
    }

    static int longestCommonSubstringLength(String x, String y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) //this means if one the lengths of strings is 0 then result will be 0 Base Condition
                {
                    t[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    result = Math.max(result, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGHIJK";
        String s2 = "ABDFHRIJK";
        int m = s1.length();
        int n = s2.length();
        System.out.println("the longest length of substring is : " + longestCommonSubstringLength(s1, s2, m, n));
    }
}
