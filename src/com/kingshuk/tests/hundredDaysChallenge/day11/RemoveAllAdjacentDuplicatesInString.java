package com.kingshuk.tests.hundredDaysChallenge.day11;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("azxxzy"));
    }
    public String removeDuplicates(String s) {
        if(s.length() <= 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            int sbl = sb.length();
            char charAtS = s.charAt(i);
            if(sbl>0 && charAtS == sb.charAt(sbl-1))
                sb.setLength(sbl-1);
            else
                sb.append(charAtS);
        }
        return sb.toString();
    }
}
