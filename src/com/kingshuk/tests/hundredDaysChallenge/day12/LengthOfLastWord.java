package com.kingshuk.tests.hundredDaysChallenge.day12;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("luffy is still joyboy"));
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        if(chars[0] != ' ')
            count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(chars[i-1] == ' ' && chars[i] != ' ')
                count = 1;
            else if(chars[i] != ' ')
                count ++;
        }
        return count;
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int lastSpaceIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                lastSpaceIndex = i;
            }
        }
        return s.length()-lastSpaceIndex-1;
    }
}
