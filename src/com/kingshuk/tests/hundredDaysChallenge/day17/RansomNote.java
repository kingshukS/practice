package com.kingshuk.tests.hundredDaysChallenge.day17;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magChars = new int[26];
        for(int i = 0; i< magazine.length(); i++){
            magChars[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i< ransomNote.length(); i++){
            if(magChars[ransomNote.charAt(i) - 'a'] == 0)
                return false;
            magChars[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }
}