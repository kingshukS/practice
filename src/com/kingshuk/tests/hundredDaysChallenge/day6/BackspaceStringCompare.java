package com.kingshuk.tests.hundredDaysChallenge.day6;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
    
    public static String getString(String str) {
        int n = str.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i --) {
            char ch = str.charAt(i);
            if(ch == '#')
                count ++;
            else {
                if(count > 0) 
                    count --;
                else
                    sb.append(ch);
            }
        }
         return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Equals: "+backspaceCompare("ab#c","ad#c"));
    }
}