package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;

public class WildcardMatching {
	public static boolean wildcardMatching(String p, String s) {
        int sIdx = 0, pIdx = 0, lastWildcardIdx = -1, sBacktrackIdx = -1, nextToWildcardIdx = -1;
        while (sIdx < s.length()) {
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                // chars match
                ++sIdx;
                ++pIdx;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                // wildcard, so chars match - store index.
                lastWildcardIdx = pIdx;
                nextToWildcardIdx = ++pIdx;
                sBacktrackIdx = sIdx;
                //storing the pidx+1 as from there I want to match the remaining pattern

            } else if (lastWildcardIdx == -1) {
                // no match, and no wildcard has been found.
                return false;
            } else {
                // backtrack - no match, but a previous wildcard was found.
                pIdx = nextToWildcardIdx;
                sIdx = ++sBacktrackIdx;
                //backtrack string from previousbacktrackidx + 1 index to see if then new pidx and sidx have same chars,
                // if that is the case that means wildcard can absorb the chars in b/w and still further we can run the algo,
                // if at later stage it fails we can backtrack
            }
        }
        for (int i = pIdx; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
	}

    public static boolean wildcardMatchingRecursive(String p, String s) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);
        return f(n-1, m-1, s, p, dp);
    }

    private static boolean f(int sIdx, int pIdx, String s, String p, int[][] dp) {

        if(sIdx<0 && pIdx<0) return true;
        if(pIdx<0) return false;
        if(sIdx<0)
        {
            for(int i = 0; i<=pIdx; i++)
            {
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if(dp[sIdx][pIdx] != -1) return dp[sIdx][pIdx] == 1;

        if(s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?') {
            boolean res = f(sIdx - 1, pIdx - 1, s, p, dp);
            dp[sIdx][pIdx] = res ? 1 : 0;
            return res;
        }
        else if(p.charAt(pIdx) == '*') {
            boolean res = f(sIdx, pIdx - 1, s, p, dp) || f(sIdx - 1, pIdx, s, p, dp);
            dp[sIdx][pIdx] = res ? 1 : 0;
            return res;
        }
        dp[sIdx][pIdx] = 0;
        return false;
    }

    public static boolean wildcardMatchingTabulation(String p, String s) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 1; i<=n; i++)
            dp[i][0] = false;

        boolean prev = true;
        for(int j = 1; j<= m; j++)
        {
            prev = prev && p.charAt(j-1) == '*';
            dp[0][j] = prev;
        }

        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static boolean wildcardMatchingSpaceOptimized(String p, String s) {
        int n = s.length();
        int m = p.length();
        boolean[] dp = new boolean[m+1];

        dp[0] = true;

        boolean prev = true;
        for(int j = 1; j<= m; j++)
        {
            prev = prev && p.charAt(j-1) == '*';
            dp[j] = prev;
        }

        for(int i = 1; i<=n; i++)
        {
            boolean[] cur = new boolean[m+1];
            for(int j = 1; j<=m; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    cur[j] = dp[j - 1];
                } else if(p.charAt(j-1) == '*') {
                    cur[j] = cur[j - 1] || dp[j];
                }else{
                    cur[j] = false;
                }
            }
            dp = cur;
        }
        return dp[m];
    }

    public static void main(String[] args) {
        String p = "a*at";
        String s = "chat";
        System.out.println(wildcardMatchingRecursive(p, s));
    }
}
