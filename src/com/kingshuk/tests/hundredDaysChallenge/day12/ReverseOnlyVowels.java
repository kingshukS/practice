package com.kingshuk.tests.hundredDaysChallenge.day12;

public class ReverseOnlyVowels {
    public static void main(String[] args) {
        ReverseOnlyVowels reverseOnlyLetters = new ReverseOnlyVowels();
        System.out.println(reverseOnlyLetters.reverseOnlyVowels("leetcode"));
    }

    public String reverseOnlyVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !isNotVowel(chars[left])) left++;
            while (left < right && !isNotVowel(chars[right])) right--;
            if (left < right) {
                char t = chars[right];
                chars[right] = chars[left];
                chars[left] = t;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private boolean isNotVowel(char aChar) {
        return !(aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u' || aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U');
    }
}
