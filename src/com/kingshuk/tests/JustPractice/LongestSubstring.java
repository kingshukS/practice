package com.kingshuk.tests.JustPractice;

import java.util.LinkedHashMap;

public class LongestSubstring {
    static void longestSubstring(String inputString) {
            LinkedHashMap<Character,Integer>  charPosMap = new LinkedHashMap();
            char[] charArray = inputString.toCharArray();
            int lenghthLongestSubstring = 0;
            String longestSubstring = null;
            for(int i =0;i<charArray.length;i++)
            {
                char ch = charArray[i];
                if(!charPosMap.containsKey(ch))
                {
                    charPosMap.put(ch,i);
                }
                else {
                    i = charPosMap.get(ch);
                    charPosMap.clear();
                }
                if(lenghthLongestSubstring < charPosMap.size())
                {
                    lenghthLongestSubstring = charPosMap.size();
                    longestSubstring = charPosMap.keySet().toString();

                }

            }

        System.out.println("Input String : "+inputString);

        System.out.println("The longest substring : "+longestSubstring);

        System.out.println("The longest Substring Length : "+lenghthLongestSubstring);

    }

    public static void main(String[] args)
    {
        longestSubstring("javaconceptoftheday");

        System.out.println("==========================");

        longestSubstring("thelongestsubstring");
    }
}
