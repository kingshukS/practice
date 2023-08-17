package com.kingshuk.tests.hundredDaysChallenge.day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
class WordPattern {
    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("aaaa", "aa aa aa aa"));
    }
    public boolean wordPattern(String pattern, String s) {
        Map<String,Character> patternMap = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        int lastSpaceIndex = -1;
        int i =0,j=0;
        for(; i<s.length() && j<pattern.length();i++){
            if(s.charAt(i) == ' '){
                String word = s.substring(lastSpaceIndex+1, i);
                lastSpaceIndex = i;
                if(patternMap.containsKey(word)){
                    if(patternMap.get(word) != pattern.charAt(j))
                        return false;
                }else{
                    if(charSet.contains(pattern.charAt(j)))
                        return false;
                    charSet.add(pattern.charAt(j));
                    patternMap.put(word, pattern.charAt(j));
                }
                j++;
            }
        }
        if(j != pattern.length()-1 )
            return false;
        String word = s.substring(lastSpaceIndex+1);
        if(patternMap.containsKey(word)){
            if(patternMap.get(word) != pattern.charAt(j))
                return false;
        }else if(charSet.contains(pattern.charAt(j)))
            return false;
        return true;
    }

    public boolean wordPatternBest(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public boolean wordPatternBest2(String pattern, String s) {
    String[] words=s.split(" ");
        if(pattern.length()!=words.length) return false;
    HashMap<Character,String> hm=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
        if(hm.containsKey(pattern.charAt(i))){
            if(!hm.get(pattern.charAt(i)).equals(words[i]))
                return false;
        }
        else{
            if(hm.containsValue(words[i]))
                return false;
            hm.put(pattern.charAt(i),words[i]);
        }
    }
        return true;}
}