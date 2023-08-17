package com.kingshuk.tests.hundredDaysChallenge.day24;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion2("ab", "eidbaooo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i = 0; i<s1.length(); i++)
        {
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            if(s1Map[i] == s2Map[i])
                count++;
        }
        for(int i = 0; i<s2.length() - s1.length(); i++){
            if(count == 26)
                return true;
            int l = s2.charAt(i) - 'a';
            s2Map[l]--;
            if(s1Map[l] == s2Map[l])
                count++;
            else if(s1Map[l] == s2Map[l]+1)
                count--;

            int r = s2.charAt(i+s1.length());
            s2Map[r]++;
            if(s1Map[r] == s2Map[r])
                count++;
            else if(s1Map[r] == s2Map[r]-1)
                count--;
        }
        return count == 26;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)
            return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(char c : s1.toCharArray())
            s1Map[c-'a']++;

        int i = 0, count = 0;
        char[] s2chars = s2.toCharArray();

        for(;i<n1;i++)
        {
            s2Map[s2chars[i]-'a']++;
        }

        for(int j=0; j<26; j++)
        {
            count+=s1Map[j]==s2Map[j]?1:0;
        }

        for(; i < n2; i++)
        {
            if(count == 26)
                return true;
            int r = s2chars[i] - 'a', l = s2chars[i-n1] - 'a';

            s2Map[r]++;
            if(s1Map[r] == s2Map[r])
                count++;
            else if(s1Map[r] == s2Map[r]-1)
                count--;

            s2Map[l]--;
            if(s1Map[l] == s2Map[l])
                count++;
            else if(s1Map[l] == s2Map[l]+1)
                count--;
        }
        return count == 26;
    }
}
