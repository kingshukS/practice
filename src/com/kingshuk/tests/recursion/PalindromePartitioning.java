package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++){
            for(int j = 0; j<=i; j++)
            {
                if(s.charAt(i) == s.charAt(j) && (i-j<=2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        func(0, s, path, ans, dp);
        return ans;
    }
    
    public void func(int index,String s,List<String> path,List<List<String>> ans, boolean[][] dp) {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i<s.length(); i++)
        {
            if(dp[index][i])
            {
                path.add(s.substring(index, i+1));
                func(i+1, s, path, ans, dp);
                path.remove(path.size()-1);
            }
        }
    }
}